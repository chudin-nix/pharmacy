package com.epam.webapphello.connection;

import com.epam.webapphello.exception.DaoException;

import java.sql.Connection;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.locks.ReentrantLock;

public class ConnectionPool {

    private static volatile ConnectionPool instance;
    private final Queue<ProxyConnection> availableConnections;
    private final Queue<ProxyConnection> connectionsInUse;

    private final ReentrantLock connectionsLock = new ReentrantLock();

    private ConnectionPool() throws DaoException {
        availableConnections = new ArrayDeque<>();
        connectionsInUse = new ArrayDeque<>();
        initializeConnections();
    }

    public static ConnectionPool getInstance() throws DaoException {
        if (instance == null) {
            synchronized (ConnectionPool.class) {
                if (instance == null) {
                    instance = new ConnectionPool();
                }
            }
        }
        return instance;
    }

    public void returnConnection(ProxyConnection proxyConnection) {
        connectionsLock.lock();
        try {
            if (connectionsInUse.contains(proxyConnection)) {
                availableConnections.offer(proxyConnection);
            }
        } finally {
            connectionsLock.unlock();
        }
    }

    public ProxyConnection getConnection() {
        connectionsLock.lock();
        try {
            if (availableConnections.isEmpty()) {
                throw new RuntimeException("No connections available");
            }
            ProxyConnection connection = availableConnections.poll();
            connectionsInUse.offer(connection);
            return connection;
        } finally {
            connectionsLock.unlock();
        }
    }

    private void initializeConnections() throws DaoException {
        //хранить количество соединений в константе
        for (int i = 0; i < 10; i++) {
            Connection connection = ConnectionFactory.create();
            ProxyConnection proxyConnection = new ProxyConnection(this, connection);
            availableConnections.offer(proxyConnection);
        }
    }
}