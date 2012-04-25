# commons-lib

[![Build Status](https://secure.travis-ci.org/number23/commons-lib.png)](http://travis-ci.org/number23/commons-lib)

## API documentation
[codox docs](http://number23.github.com/commons-lib/)

## Usage

``` clojure
(use 'de.no.number23.commons-lib.io)
(def host (prompt-re "Please choose host (dev or prd)" #"dev|prd"))
(def user (prompt-read "User"))
```


## License

Copyright (C) 2011 number23_cn <https://twitter.com/number23_cn>

Distributed under the Eclipse Public License, the same as Clojure.
