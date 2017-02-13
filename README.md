# :tulip: Tulip [![License](https://img.shields.io/badge/License-EPL%201.0-red.svg)](https://opensource.org/licenses/EPL-1.0) [![Build Status](https://travis-ci.org/domobee/tulip.svg?branch=master)](https://travis-ci.org/domobee/tulip)
Flexible API to receive information from hive instances.

## About
This API plays an important role in the structure of our project,
it will recover the values of the different **instances** deployed on 
each hive. These values are stored in MongoDB, a No-SQl database. 
This API will use **json** formatting norm for easy retreating values in clojure.

## Usage
```bash
lein ring server-headless
```
## Testing code
```bash
lein test
```
## License

Copyright © 2017 Domobee

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
