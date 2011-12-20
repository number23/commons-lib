# commons-lib

## API documentation
[codox docs](http://number23.no.de/commons-lib/doc/index.html)

## Usage

``` clojure
(use 'de.no.number23.commons-lib.io)
(def host (prompt-re "Please choose host (dev or prd)" #"dev|prd"))
(def user (prompt-read "User"))
```


## License

Copyright (C) 2011 number23_cn <number23.cn@gmail.com>

Distributed under the Eclipse Public License, the same as Clojure.
