(defproject currency-converter "1.0.0"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url  "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.3"]
                 [org.clojure/tools.cli "1.0.206"]
                 [clj-http "3.12.3"]]
  :main ^:skip-aot currency-converter.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
