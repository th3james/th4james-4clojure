(defn flattr
  [s]
  (lazy-seq
    (when-let [s (seq s)]
      (if (sequential? (first s))
        (concat (flattr (first s)) (flattr (rest s)))
        (cons (first s) (flattr (rest s)))))))


(take 3 (flattr '()))
(take 3 (flattr '(1)))
(take 3 (flattr '((1))))
(take 3 (flattr '((1) 2)))
(take 3 (flattr '((1 2) 3)))
(take 5 (flattr '((1 2) (3 4))))
(take 5 (flattr '(1 2 (3 4))))

