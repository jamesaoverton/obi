# OBI Development Workflow Prototype

The [Ontology for Biomedical Investigations (OBI)][obi] is a [formal ontology][ont] focused on scientific investigations in biology and medicine. OBI is part of the [Open Biological and Biomedical Ontologies (OBO) Foundry][obo], a consortium of projects developing high-quality, interoperable ontologies for science under open licenses and a set of shared principles.

Like other OBO projects, OBI is a surprising mixture of science, philosophy, logic, and software. The software part of OBI is written in the [Web Ontology Language (OWL)][owl] using [Protégé][protege] and `.owl` files. But as Chris Mungall discusses in this [post][], the [OWL/XML][] files that Protégé creates are not suited to [version control][]. Even small edits are likely to produce large, random changes in the `.owl` file, making it very difficult to `diff`, `patch`, branch, and merge versions. These operations are the very heart of collaborative online software development!

This project is about rethinking the software part of OBI. Can we take full advantage of

- `diff`, `patch`, and [pull requests][]
- branching, merging, and [distributed version control][]
- [automated testing][] and [continuous integration][]?

I think we can, but we have to start from the very beginning, changing how we store the source code for OBI.

[obi]: http://obi-ontology.org
[ont]: https://en.wikipedia.org/wiki/Ontology_(information_science)
[obo]: http://obofoundry.org
[owl]: https://en.wikipedia.org/wiki/Web_ontology_language
[OWL/XML]: http://www.w3.org/TR/2012/REC-owl2-xml-serialization-20121211/
[protege]: http://protege.stanford.edu
[post]: http://douroucouli.wordpress.com/2014/03/30/the-perils-of-managing-owl-in-a-version-control-system/
[automated testing]: https://en.wikipedia.org/wiki/Test_automation
[continuous integration]: https://en.wikipedia.org/wiki/Continuous_integration
[version control]: https://en.wikipedia.org/wiki/Version_control
[distributed version control]: http://en.wikipedia.org/wiki/Distributed_revision_control
[pull requests]: https://help.github.com/articles/using-pull-requests


## Usage

The code for this project is written in [Clojure][clj] and runs on the [Java Virtual Machine][jvm]. You will need:

1. [Java](https://www.java.com)
2. [Leiningen][lein]
3. a copy of this repository

    git clone https://github.com/jamesaoverton/obi.git

Then run this command inside the project to get started:

    lein run help

[clj]: http://clojure.org
[jvm]: https://en.wikipedia.org/wiki/Java_Virtual_Machine
[lein]: http://leiningen.org


## Source Code

Only a few of the files we use are written in a programming language:

- `src/obi/build.clj` the instructions for building OBI and doing various tasks
- `src/obi/util.clj` some utility functions that don't belong anywhere else
- `test/*` testing code

The rest of the source files are written in plain-text, human-readable data formats, such as tab-separated-values (`.tsv`). You can edit these files in your favourite text editor or a specialized program such as Microsoft Excel. The tool will make sure that these files are always sorted in a consistent way. `diff` will show you exactly what you've changed, you can send clean patches and pull requests, and so you can branch and merge versions of the ontology using all the standard tools.


## License

Most of the content included here is part of OBI. New content is copyright © 2014 James A. Overton and distributed under the CC-by 3.0 License, same as OBI.

