import socket
import random
import os

if __name__ == '__main__':
    file_name = os.path.dirname(os.path.abspath(__file__)) + os.sep + str(random.randint(10, 1000)) + ".txt"
    print("File name: " + file_name)
    f = open(file_name, 'w')
    
    for i in range(100):
        f.write(str(random.randint(0, 100)) + "\n")
    f.close()
    print(os.path.abspath(file_name))