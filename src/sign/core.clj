(ns sign.core
  (:gen-class))

(def max-chars 40)

(defn move-token
  [a b]
  (let [tokens (clojure.string/split b #"\s")
        [first & rest] tokens
        new-a (clojure.string/join " " [a first])
        new-b (clojure.string/join " " rest)]
    [new-a new-b]))

(defn tokenize-string
  [text]
  (clojure.string/split text #"\s"))

(defn print-border
  " Prints a followed by l times b and finishes with another a. "
  [a b l]
  (println (apply str a (apply str (repeat l b)) a)))

(defn print-top-bottom
  [l]
  (print-border "+" "-" l))

(defn print-side-border
  [l]
  (print-border "|" " " l))

(defn print-text
  [text]
  (println (apply str "|  " text "  |")))

(defn longest-line
  [lines])

(defn print-sign
  [text]
  (let [length (longest-line text)]
    (print-top-bottom length)
    (print-side-border length)
    (print-text text)
    (print-side-border length)
    (print-top-bottom length)))

(defn -main
  "Print the list of args as a string with a border/frame."
  [& args]
  (print-sign (clojure.string/join " " args)))
