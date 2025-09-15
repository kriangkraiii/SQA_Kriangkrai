#!/usr/bin/env python3
import http.server
import socketserver
import urllib.parse
import os
import signal
import sys
from pathlib import Path

class CustomHTTPRequestHandler(http.server.SimpleHTTPRequestHandler):
    def __init__(self, *args, **kwargs):
        super().__init__(*args, directory=".", **kwargs)
    
    def do_POST(self):
        # จัดการ POST request สำหรับ form submission
        if self.path == '/Lab10/Success.html':
            # Redirect ไปหน้า Success
            self.send_response(302)
            self.send_header('Location', '/Lab10/Success.html')
            self.end_headers()
        else:
            self.do_GET()
    
    def end_headers(self):
        self.send_header('Cache-Control', 'no-cache, no-store, must-revalidate')
        self.send_header('Pragma', 'no-cache')
        self.send_header('Expires', '0')
        super().end_headers()

def signal_handler(sig, frame):
    print('\nShutting down server...')
    sys.exit(0)

def start_server():
    PORT = 7272
    
    # ตรวจสอบว่ามีไฟล์ HTML อยู่หรือไม่
    registration_file = Path("Lab10/Registration.html")
    success_file = Path("Lab10/Success.html")
    
    if not registration_file.exists():
        print(f"Error: {registration_file} not found!")
        sys.exit(1)
    
    if not success_file.exists():
        print(f"Error: {success_file} not found!")
        sys.exit(1)
    
    # Handle Ctrl+C gracefully
    signal.signal(signal.SIGINT, signal_handler)
    
    print(f"Starting server at http://localhost:{PORT}")
    print(f"Registration page: http://localhost:{PORT}/Lab10/Registration.html")
    print(f"Success page: http://localhost:{PORT}/Lab10/Success.html")
    print("Press Ctrl+C to stop the server")
    
    try:
        with socketserver.TCPServer(("", PORT), CustomHTTPRequestHandler) as httpd:
            httpd.serve_forever()
    except OSError as e:
        if e.errno == 48:  # Address already in use
            print(f"Error: Port {PORT} is already in use. Please stop any existing server first.")
        else:
            print(f"Error starting server: {e}")
        sys.exit(1)

if __name__ == "__main__":
    start_server()