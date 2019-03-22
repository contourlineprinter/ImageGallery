import socket

client = socket.socket()
port = 12345
client.connect(('127.0.0.1', port))
while True:
    data, ad = client.recv(1024)
    print("Received message from server: %s" % data)

client.close()