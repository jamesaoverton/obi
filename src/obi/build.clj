;; Code for building OBI and performing other tasks.
(ns obi.build
    (:gen-class)
    (:require [obi.util :refer :all]
              [clojure.string :as string]
              [clojure.tools.cli :refer [parse-opts]]))

;; TASKS

(defn build
  "Build an obi.owl file"
  [options]
  (println "Build task is not yet implemented!"))


;; COMMAND LINE
;; Sticking close to the example here:
;; https://github.com/clojure/tools.cli
;; No options yet.

(def cli-options
  [])

(defn usage
  "Print the usage info for this tool."
  [options-summary]
  (->> ["Build OBI and perform other tasks."
        ""
        "Usage: lein run [options] action"
        ""
        ;"Options:"
        ;options-summary
        ;""
        "Actions:"
        "  help    get help"
        "  build   build an obi.owl file"]
       (string/join \newline)))

(defn error-msg
  "Print an error message."
  [errors]
  (str "The following errors occurred while parsing your command:\n\n"
        (string/join \newline errors)))

(defn exit
  "Print a message and exit."
  [status msg]
  (println msg)
  (System/exit status))

(defn -main
  "Process command line arguments."
  [& args]
  (let [{:keys [options arguments errors summary]}
        (parse-opts args cli-options)]
    ;; Handle help and error conditions
    (cond
      (:help options) (exit 0 (usage summary))
      (not= (count arguments) 1) (exit 1 (usage summary))
      errors (exit 1 (error-msg errors)))
    ;; Execute program with options
    (case (first arguments)
      "build" (build options)
      (exit 1 (usage summary)))))

