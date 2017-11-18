(ns sign.core
  (:gen-class))

(def max-char 40)

(defn move-token
  [a b]
  (let [tokens (clojure.string/split b #"\s")
        [first & rest] tokens
        new-a (clojure.string/join " " [a first])
        new-b (clojure.string/join " " rest)]
    [new-a new-b]))

(defn make-max-strings
  [text l]
  (let [tokens (clojure.string/split text #"\s")
        [first & rest] tokens
        text (clojure.string/join " "  [text first])]))

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

(defn max-length
  [text]
  (+ 4 (count text)))

(defn make-lines
  "Takes a seq of words and concats them together.
    Returns a seq of lines, each of them shorter than limit."
  [words limit])

(defn split-at-limit
  [text limit]
  (if (< limit (count text))
    (let [pos (clojure.string/last-index-of text " " 40)
          a (subs text 0 pos)
          b (subs text (+ 1 pos) (count text))]
      [a b])
    [text]))

(defn make-sign-lines
  [text limit]
  (loop [t text]
    (let [tmp (split-at-limit t limit)]
      (println tmp)
      (if (< limit (count (tmp 1)))
        (recur (tmp 1))))))

(defn print-sign
  [text]
  (let [length (max-length text)]
    (print-top-bottom length)
    (print-side-border length)
    (print-text text)
    (print-side-border length)
    (print-top-bottom length)))

(defn -main
  "Print the list of args as a string with a border/frame."
  [& args]
  (print-sign (clojure.string/join " " args)))
