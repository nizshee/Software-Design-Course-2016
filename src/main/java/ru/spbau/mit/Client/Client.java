package ru.spbau.mit.Client;

import ru.spbau.mit.Protocol.RemoteFile;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public interface Client {
    void connect(String hostName, short port) throws IOException;
    void disconnect() throws IOException;
    List<RemoteFile> executeList(String path) throws IOException;
    void executeGet(String path, OutputStream out) throws IOException;
}
