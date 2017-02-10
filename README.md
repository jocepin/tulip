# :tulip: Tulip [![Crates.io](https://img.shields.io/crates/l/rustc-serialize.svg)]() [![Build Status](https://travis-ci.org/domobee/tulip.svg?branch=master)](https://travis-ci.org/domobee/tulip)
Flexible API to receive information from hive instances.

## About
This APP plays an important role in the structure of our project,
it will recover the values of the different **instances** deployed on 
each hive. These values are stored in MongoDB, a No-SQl database. 
This API will use **json** formatting norm for easy retreating values in clojure.

## Usage
```bash
lein ring server-headless
```
## License

Copyright © 2017 Domobee

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
