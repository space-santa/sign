(ns sign.core
  (:gen-class))

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
  (println (apply str "| " text " |")))

(defn print-sign
  [text]
  (let [length (+ 2 (count text))]
    (print-top-bottom length)
    (print-side-border length)
    (print-text text)
    (print-side-border length)
    (print-top-bottom length)))

(defn -main
  "Print the first arg as a string with a border/frame."
  [& args]
  (print-sign (first args)))
