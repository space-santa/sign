(ns sign.core
  (:gen-class))

(def max-chars 40)

(defn conj-trimmed-string
  [v s]
  (conj v (clojure.string/trim s)))

(defn longest-string
  "Returns the length of the longest string in the given vector of strings."
  [words]
  (loop [s words, l 0]
    (if (> (count s) 0)
      (let [newlength (count (first s))]
        (if (> newlength l)
          (recur (rest s) newlength)
          (recur (rest s) l)))
      l)))

(defn make-lines
  "Takes a vector of strings and concatenates them to lines no longer than limit."
  [words limit]
  (if (> (longest-string words) limit)
    (throw (IllegalArgumentException. (str "No word can be longer than " limit)))
    (loop [retval [] tmpstring "" tmpwords words]
      (if (> (count tmpwords) 0)
        (let [oldstring tmpstring
              tmpstring (apply str tmpstring " " (first tmpwords))]
          (if (> (count tmpstring) limit)
            (recur (conj-trimmed-string retval oldstring)
                   (first tmpwords)
                   (rest tmpwords))
            (recur retval tmpstring (rest tmpwords))))
        (conj-trimmed-string retval tmpstring)))))

(defn tokenize-string
  "Splits a string at whitespace and returns a vector of the tokens."
  [text]
  (clojure.string/split text #"\s"))

(defn print-border
  " Prints a followed by l times b and finishes with another a. "
  [a b l]
  (println (str a (apply str (repeat l b)) a)))

(defn print-top-bottom
  [l]
  (print-border "+" "-" l))

(defn print-side-border
  [l]
  (print-border "|" " " l))

(defn print-text-in-border
  [text l]
  (println (str "|  " text (apply str (repeat (- l (count text)) " ")) "  |")))

(defn print-sign
  [text]
  (let [words (tokenize-string text)
        lines (make-lines words 40)
        length (longest-string lines)
        full-length (+ 4 length)]
    (print-top-bottom full-length)
    (print-side-border full-length)
    (dorun (map #(print-text-in-border % length) lines))
    (print-side-border full-length)
    (print-top-bottom full-length)))

(defn -main
  "Print the list of args as a string with a border/frame."
  [& args]
  (print-sign (clojure.string/join " " args)))
