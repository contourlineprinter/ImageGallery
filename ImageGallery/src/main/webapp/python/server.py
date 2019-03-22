import socket
import random
import os

if __name__ == '__main__':
    server = socket.socket(socket.AF_INET, socket.SOCK_DGRAM, socket.IPPROTO_UDP)
    server.setsockopt(socket.SOL_SOCKET, socket.SO_BROADCAST, 1)
    server.settimeout(0.4)
    server.bind(("", 44444))

    file_name = "data" + os.sep + str(random.randint(10, 1000)) + ".txt"

    f = open(file_name, 'w')
    for i in range(100):
        f.write(str(random.randint(0, 100)) + "\n")
    f.close()

    message = b''+file_name
    server.sendall(message)