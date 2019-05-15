package server;

public class ClientsList {
    private String clientName;
    private String connName;
    public static int counter=1;

    public ClientsList(String connName,String clientName) {
        this.clientName = clientName;
        this.connName = connName;
    }

    public String getClientName() {
        return clientName;
    }

    public String getConnName() {
        return connName;
    }

    public static int getCounter() {
        return counter;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void setConnName(String connName) {
        this.connName = connName;
    }

    public static void setCounter(int counter) {
        ClientsList.counter = counter;
    }
}
