(defn palindrome
  [s]
  (let [rev (reverse s)]
    (every? (fn [[f b]] (= f b))
            (map vector s rev))))


(and
  (palindrome '())
  (palindrome '(1))
  (palindrome '(1 1))
  (not (palindrome '(1 2))))

