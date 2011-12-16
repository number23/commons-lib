# commons-lib

## Usage

``` clojure
(use 'org.clojars.number23_cn.commons-lib.io)
(def host (prompt-re "Please choose host (dev or prd)" #"dev|prd"))
(def user (prompt-read "User"))
```


## License

Copyright (C) 2011 number23_cn <number23.cn@gmail.com>

Distributed under the Eclipse Public License, the same as Clojure.
