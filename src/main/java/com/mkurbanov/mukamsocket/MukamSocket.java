package com.mkurbanov.mukamsocket;

import android.util.Log;

import java.io.IOException;
import java.net.Socket;

/**
 * @author Break
 */

public class MukamSocket {
    private Socket mSocket = null;
    private String mHost = null;
    private int mPort = 0;

    public static final String LOG_TAG = "MUKAM_SOCKET";

    public MukamSocket() {
    }

    public MukamSocket(String mHost, int mPort) {
        this.mHost = mHost;
        this.mPort = mPort;
    }

    /**
     * open socket
     */
    public void openConnection() throws Exception {
        // Если сокет уже открыт, то он закрывается
        closeConnection();
        try {
            // Создание сокета
            mSocket = new Socket(mHost, mPort);
        } catch (IOException e) {
            throw new Exception("open socket error: " + e.getMessage());
        }
    }

    /**
     * close socket
     */
    public void closeConnection() {
        /* Проверяем сокет. Если он не зарыт, то закрываем его и освобдождаем соединение.*/
        if (mSocket != null && !mSocket.isClosed()) {
            try {
                mSocket.close();
            } catch (IOException e) {
                Log.e(LOG_TAG, "close socket error: " + e.getMessage());
            } finally {
                mSocket = null;
            }
        }
        mSocket = null;
    }

    /**
     * send data
     */
    public void sendData(byte[] data) throws Exception {
        // Проверка открытия сокета
        if (mSocket == null || mSocket.isClosed()) {
            throw new Exception("socket data send error. Socket not created");
        }
        // Отправка данных
        try {
            mSocket.getOutputStream().write(data);
            mSocket.getOutputStream().flush();
        } catch (IOException e) {
            throw new Exception("can't send data: " + e.getMessage());
        }
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        closeConnection();
    }
}
