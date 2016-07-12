#!/usr/bin/bash

curl -X POST -F 'key1=value1' -F 'key2=value2' -F 'file1=@test1.txt' -F 'file2=@test2.txt' http://localhost:8080/my-srv/my/downloads
