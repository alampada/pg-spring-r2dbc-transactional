#!/usr/bin/env bash
docker run -it -d --rm -e POSTGRES_PASSWORD=postgres -v `pwd -P`/sql:/docker-entrypoint-initdb.d --name pgtransaction postgres:12.4


docker inspect pgtransaction | grep -i ipaddress


