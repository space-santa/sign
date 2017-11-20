(defproject sign "1.0.0"
  :description "Makes a string of all args and prints it in a frame."
  :url "https://github.com/space-santa/sign"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]]
  :main ^:skip-aot sign.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
