#!/bin/bash

nohup java -jar rpc-demo-consumer-1.0-SNAPSHOT.jar &
tail -f nohup.out