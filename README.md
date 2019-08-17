# env
Easy clojure environment variables

## Quickstart

Given an `.env` file in the root of your project directory:

```sh
A_VALUE=hello
```

```clojure
(ns your-project
  (:require [env.core :as env]))

(env/env :a-value) ; => hello
```

## Install

Add this to your [deps.edn](https://clojure.org/guides/deps_and_cli)

```clojure
coast-framework/env {:mvn/version "1.0.2"}}
```

## Usage

Given a `.env` file above or the equivalent `env.edn`

### Conventions

Notice system environment variables and values in `.env` are all upper and snake case, while the `env.edn` variables are all lower, kebab case keywords.

```clojure
{:a-value "hello"}
```

This will return "hello"

```clojure
(env/env :a-value)
```

### Tagged literals

`env.edn` has one trick up it's sleeve, tagged literals. You can set a `#env` tagged literal to grab a value from the actual environment and commit `env.edn` *without* committing the secret to source control.

`env.edn` (committed to source control)

```clojure
{:a-secret-value #env :session-key}
```

`.env` (not committed to source control)

```sh
SESSION_KEY=123456
COAST_ENV=dev
```

```clojure
(env/env :a-secret-value) ; => "123456"
```

## Running the tests

```sh
cd env && make test
```
