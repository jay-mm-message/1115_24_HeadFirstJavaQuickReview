
if [ -z "$1" ]; then
    echo "err: path is not found"
else
    java -jar ./Jar/UMLParserClass.jar $1 uml_graph.png
    code $1/uml_graph.png
fi