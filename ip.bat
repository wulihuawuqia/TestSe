@echo off
netsh interface ip set address name="ÒÔÌ«Íø" source=static addr=192.168.3.140 mask=255.255.255.0 gateway=192.168.3.254
netsh interface ip set dns name="ÒÔÌ«Íø" source=static addr=202.101.172.35
@pause