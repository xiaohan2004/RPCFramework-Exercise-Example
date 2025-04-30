#!/bin/bash

nohup java -jar rpc-demo-registry-1.0-SNAPSHOT.jar &
tail -f nohup.out