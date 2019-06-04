# Java challenge

### Description
This application provides a REST API that counts the words of a classified.
The API consists of two endpoints:
#### POST /word/count
Counts the words of pure text.

Sample request:

`{
"text": "ΖΗΤΟΥΝΤΑΙ υπάλληλοι σε καταστήματα πώλησης παραδοσιακών προϊόντων 900 ευρω"
}`

Sample response:

`{
    "text": "ΖΗΤΟΥΝΤΑΙ υπάλληλοι σε καταστήματα πώλησης παραδοσιακών προϊόντων 900 ευρω",
    "words": 9,
    "eurosAmount": 900
}`

#### POST /word/countHtml
Counts the words of html text.

Sample request:

`{
	"text": "<!DOCTYPE html><html><body><textarea rows='4' cols='50' name='comment' form='usrform'>ΑΝΑΒΥΣΣΟΣ μεζονέτα 195 τ.μ., ισόγεια, 3 υ/δ, κατασκευή '12, 2 μπάνια, σε οικόπεδο 375 τ.μ., αυτόνομη θέρμανση, κλιματισμός, τζάκι, θέα θάλασσα, κλειστό πάρκιν, αποθήκη, κήπος, άριστη κατάσταση, 2 κυρίως επιπέδων, ευήλιο καθιστικό με θέα, υπόγειο φωτεινό που χρησιμοποιείται ως πλήρης ξενώνας, πισίνα με εξοπλισμένο περιβάλλοντα χώρο χαλάρωσης, walking distance από οργανωμένη παραλία, τιμή 570.000€</textarea></body></html>"
}`

Sample response:

`{
    "text": "ΑΝΑΒΥΣΣΟΣ μεζονέτα 195 τ.μ., ισόγεια, 3 υ/δ, κατασκευή '12, 2 μπάνια, σε οικόπεδο 375 τ.μ., αυτόνομη θέρμανση, κλιματισμός, τζάκι, θέα θάλασσα, κλειστό πάρκιν, αποθήκη, κήπος, άριστη κατάσταση, 2 κυρίως επιπέδων, ευήλιο καθιστικό με θέα, υπόγειο φωτεινό που χρησιμοποιείται ως πλήρης ξενώνας, πισίνα με εξοπλισμένο περιβάλλοντα χώρο χαλάρωσης, walking distance από οργανωμένη παραλία, τιμή 570.000€",
    "words": 51,
    "eurosAmount": 570000
}`
### How to run

Build the project and run tests with the following command:
`mvn clean install`

and run the application:
`mvn spring-boot:run`

######Technologies used:
Spring Boot, Java 8, Maven, Intellij, jsoup, Spring Test