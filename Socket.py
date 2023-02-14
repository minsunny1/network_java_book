import socket

print("에코 클라이언트 시작됨")
client_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
# 파이썬은 TCP 기반
client_socket.connect(("127.0.0.1", 10000))
print("서버에 연결됨")

while True:
        msg = input("전송 메세지 입력: ")
        if msg == "exit" or msg == "EXIT":  # 종료
            break
        client_socket.sendall((msg + "\n").encode())  # 송신
        data = client_socket.recv(1024).decode()  # 수신
        print(f"서버로부터 받은 메세지: {data}")

client_socket.close()
