package gr.xe.challenge;


import gr.xe.challenge.controller.WordController;
import gr.xe.challenge.dto.WordCountRequest;
import gr.xe.challenge.service.WordService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.boot.test.context.TestConfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(WordController.class)
public class WordControllerTest {

    @Autowired
    private MockMvc mvc;
    private static final String classifiedTextWithPhone = "Μεσιτικη εταιρεια στα πλαισια της διαρκους αναπτυξης της ζητει \"Assistant Manager\", προσφεροντας ενα ιδιαιτερα ελκυστικο πακετο αμοιβων, μεγαλες προοπτικες περαιτερω εξελιξης. Ο ιδανικος υποψηφιος/α, θα πρεπει να διαθετει: εμπειρια στον κλαδο των ακινητων ή της διαχειρισης ανθρωπινου δυναμικου, οργανωτικο πνευμα, και διαπραγματευτικες ικανοτητες Τηλ επικοινωνιας 6999999999(153) 400€";
    private static final String classifiedTextWithEmail = "ΖΗΤΟΥΝΤΑΙ υπάλληλοι σε καταστήματα πώλησης παραδοσιακών προϊόντων και καλλυντικών για την περίοδο Ιουνίου έως και Σεπτεμβρίου (4 Μήνες). Απαραίτητη γνώση της Αγγλικής γλώσσας, γνώση ρωσικής γλώσσας θα εκτιμηθεί. Διαμονή πληρωμένη σε διαμέρισμα κοντά στο χώρο εργασίας. Μισθός 800 ευρώ. email: info@here.gr";
    private static final String classifiedTextWithAbbreviation = "ΚΥΨΕΛΗ διαμέρισμα 60 τ.μ., 1ου, προσόψεως, διαμπερές, 1 υ/δ, μπάνιο, ξεχωριστή κουζίνα, κλιματισμός, πόρτα ασφαλείας, ελεύθερο, ανακαινισμένο, εξαιρετικό πλήρως ανακαινισμένο διαμέρισμα σε ήσυχη περιοχή, αποτελείται από ένα φωτεινότατο σαλόνι, ξεχωριστή ανακαινισμένη κουζίνα, ανακαινισμένο μπάνιο. Διπλά τζάμια, ανακαινισμένη κουζίνα, μπάνιο, πατώματα. Ανακαινισμένα ηλεκτρικά και υδραυλικά. Η ανακαίνιση έγινε το 2019. Μόλις 4 λεπτά από τα δικαστήρια στην Ευελπίδων. Κατάλληλο και για επαγγελματική χρήση.";
    private static final String classifiedTextWithCapitalsAndEmail = "ΚΥΒΕΡΝΗΤΗΣ Γ' πιστοποιημένος ζητείται για ημερόπλοιο μοντέλου Πέραμα στη Μύκονο there@gmail.com";
    private static final String classifiedTextEnglish = "ABARTH S4 595FL, 1.400 cc, μοντ. 6/'17, 160 hp, μαύρο μεταλλικό, 4.000 χλμ., 3θυρο, Τ-Jet Pista 1368, 10 φορολογίσιμοι ίπποι, τιμή 10.000€";
    private static final String classifiedText = "ΑΝΑΒΥΣΣΟΣ μεζονέτα 195 τ.μ., ισόγεια, 3 υ/δ, κατασκευή '12, 2 μπάνια, σε οικόπεδο 375 τ.μ., αυτόνομη θέρμανση, κλιματισμός, τζάκι, θέα θάλασσα, κλειστό πάρκιν, αποθήκη, κήπος, άριστη κατάσταση, 2 κυρίως επιπέδων, ευήλιο καθιστικό με θέα, υπόγειο φωτεινό που χρησιμοποιείται ως πλήρης ξενώνας, πισίνα με εξοπλισμένο περιβάλλοντα χώρο χαλάρωσης, walking distance από οργανωμένη παραλία, τιμή 570.000€";
    private static final String classifiedTextHtml = "<!DOCTYPE html>\n" +
            "<html>\n" +
            "<body>\n" +
            " \n" +
            "<textarea rows=\"4\" cols=\"50\" name=\"comment\" form=\"usrform\">\n" +
            " ΑΝΑΒΥΣΣΟΣ μεζονέτα 195 τ.μ., ισόγεια, 3 υ/δ, κατασκευή '12, 2 μπάνια, σε οικόπεδο 375 τ.μ., αυτόνομη θέρμανση, κλιματισμός, τζάκι, θέα θάλασσα, κλειστό πάρκιν, αποθήκη, κήπος, άριστη κατάσταση, 2 κυρίως επιπέδων, ευήλιο καθιστικό με θέα, υπόγειο φωτεινό που χρησιμοποιείται ως πλήρης ξενώνας, πισίνα με εξοπλισμένο περιβάλλοντα χώρο χαλάρωσης, walking distance από οργανωμένη παραλία, τιμή 570.000€" +
            "</textarea>\n" +
            " \n" +
            "</body>\n" +
            "</html>\n";

    @TestConfiguration
    static class WordServiceTestContextConfiguration {

        @Bean
        public WordService wordService() {
            return new WordService();
        }
    }

    @Test
    public void countWordsWithPhoneTest() throws Exception {
        WordCountRequest request = new WordCountRequest();
        request.setText(classifiedTextWithPhone);
        mvc.perform(post("/word/count")
                .content(Utils.asJsonString(request))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.words").value("45"))
                .andExpect(jsonPath("$.text").value(classifiedTextWithPhone))
                .andExpect(jsonPath("$.eurosAmount").value(400d));
    }

    @Test
    public void countWordsWithEmailTest() throws Exception {
        WordCountRequest request = new WordCountRequest();
        request.setText(classifiedTextWithEmail);
        mvc.perform(post("/word/count")
                .content(Utils.asJsonString(request))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.words").value("41"))
                .andExpect(jsonPath("$.text").value(classifiedTextWithEmail))
                .andExpect(jsonPath("$.eurosAmount").value(800d));
    }

    @Test
    public void countWordsWithAbbreviationTest() throws Exception {
        WordCountRequest request = new WordCountRequest();
        request.setText(classifiedTextWithAbbreviation);
        mvc.perform(post("/word/count")
                .content(Utils.asJsonString(request))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.words").value("59"))
                .andExpect(jsonPath("$.text").value(classifiedTextWithAbbreviation));
    }

    @Test
    public void countWordsWithCapitalsAndEmailTest() throws Exception {
        WordCountRequest request = new WordCountRequest();
        request.setText(classifiedTextWithCapitalsAndEmail);
        mvc.perform(post("/word/count")
                .content(Utils.asJsonString(request))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.words").value("11"))
                .andExpect(jsonPath("$.text").value(classifiedTextWithCapitalsAndEmail));
    }

    @Test
    public void countWordsEnglishTest() throws Exception {
        WordCountRequest request = new WordCountRequest();
        request.setText(classifiedTextEnglish);
        mvc.perform(post("/word/count")
                .content(Utils.asJsonString(request))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.words").value("22"))
                .andExpect(jsonPath("$.text").value(classifiedTextEnglish))
                .andExpect(jsonPath("$.eurosAmount").value(10000d));
    }


    @Test
    public void countWordTextTest() throws Exception {
        WordCountRequest request = new WordCountRequest();
        request.setText(classifiedText);
        mvc.perform(post("/word/count")
                .content(Utils.asJsonString(request))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.words").value("51"))
                .andExpect(jsonPath("$.text").value(classifiedText))
                .andExpect(jsonPath("$.eurosAmount").value(570000d));
    }

    @Test
    public void countWordHtmlTextTest() throws Exception {
        WordCountRequest request = new WordCountRequest();
        request.setText(classifiedTextHtml);
        mvc.perform(post("/word/countHtml")
                .content(Utils.asJsonString(request))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.words").value("51"))
                .andExpect(jsonPath("$.text").value(classifiedText))
                .andExpect(jsonPath("$.eurosAmount").value(570000d));
    }


    @Test
    public void countWordWithNullTextTest() throws Exception {
        WordCountRequest request = new WordCountRequest();
        request.setText(null);
        mvc.perform(post("/word/count")
                .content(Utils.asJsonString(request))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(400));
    }
}
