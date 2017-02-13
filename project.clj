(defproject tulip "0.1.0-ALPHA"
  :description "Flexible API to receive information from hive instances."
  :url "https://github.com/domobee/tulip"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :clean-non-project-classes true
  :javac-options ["-target" "1.6" "-source" "1.6" "-Xlint:-options"]
  :repl-options { :prompt (fn [ns] (str "your command for <" ns ">, master? " ))
                  :welcome (println "Welcome to the magical world of the repl!")
                  :init-ns tulip.core
                  :init (println "here we are in" *ns*)
                  :caught clj-stacktrace.repl/pst+
                  :skip-default-init false                
                  :host "0.0.0.0"
                  :port 4001
                 :timeout 40000}

  :jar-name "tulip.jar"
  :uberjar-name "tulip-standalone.jar"
  :omit-source true
  :jar-exclusions [#"(?:^|/).svn/"]
  :uberjar-exclusions [#"META-INF/DUMMY.SF"]
  :install-releases? false
  :deploy-branches ["master"]
  :main ^:skip-aot tulip.core
  :profiles {:uberjar {:aot :all}
             :dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                                  [ring-mock "0.1.5"]]}}
  :bin {:name "tulip"}
  :plugins [[lein-ring "0.11.0"]]
  :ring {:handler tulip.app/app}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [ring/ring-core "1.6.0-beta7"]
                 [ring/ring-json "0.4.0"]
                 [compojure "1.5.2"]])
