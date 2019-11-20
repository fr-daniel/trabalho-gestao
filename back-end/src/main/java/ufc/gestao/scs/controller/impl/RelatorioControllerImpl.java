package ufc.gestao.scs.controller.impl;

import java.io.File;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ufc.gestao.scs.controller.RelatorioController;

@RestController
@RequestMapping("/relatorio")
public class RelatorioControllerImpl implements RelatorioController {

    public static final String DEST = "./target/sandbox/tables/simple_table.pdf";

    @Override
    public ResponseEntity<Void> createRelatorioSimples() {
        // File file = new File(DEST);
        // file.getParentFile().mkdirs();
        // new SimpleTable().manipulatePdf(DEST);
        // PdfDocumen
        return null;
    }

}