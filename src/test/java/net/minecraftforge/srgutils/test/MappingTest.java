/*
 * SRG Utils
 * Copyright (c) 2021
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation version 2.1
 * of the License.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 */

package net.minecraftforge.srgutils.test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import net.minecraftforge.srgutils.IRenamer;
import net.minecraftforge.srgutils.MappingFile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import net.minecraftforge.srgutils.IMappingFile;
import net.minecraftforge.srgutils.IMappingFile.Format;
import net.minecraftforge.srgutils.INamedMappingFile;

public class MappingTest {

    InputStream getStream(String name) {
        return MappingTest.class.getClassLoader().getResourceAsStream(name);
    }

    @Test
    void test() throws IOException {
        IMappingFile pg = IMappingFile.load(getStream("./installer.pg"));
        IMappingFile reverse = pg.reverse();
        for (Format f : Format.values()) {
            pg.write(Paths.get("./build/installer_out." + f.name().toLowerCase()), f, false);
            reverse.write(Paths.get("./build/installer_out_rev." + f.name().toLowerCase()), f, false);
        }
    }

    public static void main(String[] args) throws IOException {
//        toSrg();
    }

    @Test
    void writeSrgToYarn1_18_2() throws IOException {
        IMappingFile obfToSrg = IMappingFile.load(Files.newInputStream(Paths.get("D:\\.gradle\\caches\\forge_gradle\\minecraft_user_repo\\de\\oceanlabs\\mcp\\mcp_config\\1.18.2-20220404.173914\\obf_to_srg.tsrg2")));
//        IMappingFile obfToSrg = IMappingFile.load(Files.newInputStream(Paths.get("D:\\.gradle\\caches\\forge_gradle\\minecraft_user_repo\\de\\oceanlabs\\mcp\\mcp_config\\1.18.2-20220404.173914\\obf_to_srg.tsrg2")));
//        obfToSrg.reverse()
    }

    @Test
    void toSrg() throws IOException {
        var mappingDir = "D:\\IDEAProjects\\MITE1.18.2\\toolchain\\mappings\\";
        var lambdaMatch = new File(mappingDir + "lambda_match.tiny");
        var yarn_official = new File(mappingDir + "yarn-official.tiny");
        var manual = new File(mappingDir + "manual_mappings.tiny");
        String lambdaReobfMapping = mappingDir + "lambda_yarn_official.tiny";
        String officialToIntermediary = "D:\\IDEAProjects\\MITE1.18.2\\toolchain\\mappings.tiny";
//        var out = new File(lambdaReobfMapping);
//        var lambdas = IMappingFile.load(lambdaMatch);
//        var yarnToOfficial = IMappingFile.load(yarn_official);
//        var manualMapping = IMappingFile.load(manual);
//        lambdas.chain(yarnToOfficial).merge(yarnToOfficial).merge(manualMapping).write(out.toPath(), IMappingFile.Format.TINY, false);
        String autoObfuscateMapping = mappingDir + "auto_obfuscate.tiny";
        String officialToIntermediaryMITE = mappingDir + "official_intermediary_MITE.tiny";
        IMappingFile.load(new File(lambdaReobfMapping))
                .merge(IMappingFile.load(new File(autoObfuscateMapping)))
                .chainToNamed(IMappingFile.load(new File(officialToIntermediaryMITE)),"named","official", "intermediary")
                .write(new File(mappingDir + "yarn-1.18.2+build.4-MITE-v0.6.5-beta.tiny").toPath(), IMappingFile.Format.TINY, "official","intermediary","named");
//        IMappingFile lambdas = IMappingFile.load(Files.newInputStream(Paths.get("F:\\IDEAProjects\\SpecialSource\\lambda_match.srg")));
//        IMappingFile intermediaryToOffical = IMappingFile.load(Files.newInputStream(Paths.get("F:\\IDEAProjects\\MITE1.18\\deofficial\\intermediary-official.tsrg")));
//        lambdas.write(Paths.get("F:\\IDEAProjects\\SpecialSource\\lambda_match.tiny"),Format.TINY,false);
//        IMappingFile lambdasTiny = IMappingFile.load(Files.newInputStream(Paths.get("F:\\IDEAProjects\\SpecialSource\\lambda_match.tiny")));
//        IMappingFile officialToIntermediary = IMappingFile.load(Files.newInputStream(Paths.get("F:\\IDEAProjects\\MITE1.18\\deofficial\\official-intermediary.tiny")));
//        IMappingFile yarnToOfficial = IMappingFile.load(Files.newInputStream(Paths.get("F:\\IDEAProjects\\MITE1.18\\deofficial\\yarn-official.tiny")));
//        IMappingFile intermediaryToYarn = IMappingFile.load(Files.newInputStream(Paths.get("F:\\IDEAProjects\\MITE1.18\\deofficial\\intermediary-yarn.tiny")));
//        IMappingFile intermediaryToYarn_1_18_2 = IMappingFile.load(Files.newInputStream(Paths.get("F:\\.gradle\\caches\\fabric-loom\\1.18.2\\net.fabricmc.yarn.1_18_2.1.18.2+build.3-v2\\mappings-base.tiny")));
//        IMappingFile officialToIntermediary_1_18_2 = IMappingFile.load(Files.newInputStream(Paths.get("F:\\.gradle\\caches\\fabric-loom\\1.18.2\\intermediary-v2.tiny")));
//        officialToIntermediary_1_18_2.chain(intermediaryToYarn_1_18_2).write();

//        officialToIntermediary.chain(intermediaryToYarn_1_18_2).write((Paths.get("F:\\IDEAProjects\\MITE1.18\\deofficial\\offical-yarn_1.18.2.tsrg")),Format.TSRG,false);
//        officialToIntermediary_1_18_2.chain(intermediaryToYarn_1_18_2).reverse().write(Paths.get("F:\\IDEAProjects\\MITE1.18.2\\toolchain\\yarn-official.tiny"),Format.TINY,false);
//        officialToIntermediary_1_18_2.chain(intermediaryToYarn_1_18_2).write(Paths.get("F:\\IDEAProjects\\MITE1.18.2\\toolchain\\official-yarn.tiny"),Format.TINY,false);
//        lambdasTiny.merge(yarnToOfficial).write(Path.of("./lambda_yarnToOfficial.tiny"),Format.TINY,false);
//        intermediaryToYarn.reverse().chain(officialToIntermediary_1_18_2.reverse()).write(Paths.get("F:\\IDEAProjects\\MITE1.18.2\\deofficial\\yarn-official-1.18.2.tiny"),Format.TINY,false);
//        lambdasTiny.chain(intermediaryToYarn.reverse()).reverse().chain(intermediaryToYarn.reverse()).chain(intermediaryToYarn_1_18_2).reverse().chain(intermediaryToOffical).write(Paths.get("F:\\IDEAProjects\\SpecialSource\\lambda_match_official2.tiny"),Format.TINY,false);

//        IMappingFile officialToYarn = IMappingFile.load(Files.newInputStream(Paths.get("F:\\IDEAProjects\\MITE1.18\\deofficial\\offical-yarn.tsrg")));
//        IMappingFile mcpToOfficial =  IMappingFile.load(Files.newInputStream(Paths.get("F:\\IDEAProjects\\MITE1.18\\deofficial\\mcp_config-1.18-obf_to_srg.tsrg"))).reverse();

//        IMappingFile intermediaryNamed = IMappingFile.load(Files.newInputStream(Paths.get("F:\\IDEAProjects\\MITE1.18\\deofficial\\intermediary-named.tiny")));
//        IMappingFile intermediaryToYarn = IMappingFile.load(Files.newInputStream(Paths.get("F:\\IDEAProjects\\MITE1.18\\deofficial\\intermediary-named.tiny")));
//        officailIntermediary.chain(intermediaryToYarn).reverse().write(Paths.get("F:\\IDEAProjects\\MITE1.18\\deoffcial\\yarn-official.tiny"),Format.TINY,false);

//        IMappingFile lambda_yarnToOfficial = IMappingFile.load(Files.newInputStream(Paths.get("F:\\IDEAProjects\\MITE1.18\\toolchain\\lambda_yarn-official.tsrg")));
//        yarnToIntermediary.merge(lambda_yarnToIntermediary).chain(officailIntermediary.reverse()).write(Paths.get("F:\\IDEAProjects\\MITE1.18\\toolchain\\lambda_yarn-official.tiny"),Format.TINY1,false);
//        officailIntermediary.chain(intermediaryNamed).write(Paths.get("F:\\IDEAProjects\\MITE1.18\\toolchain\\lambda_yarn-official.tiny"),Format.TINY1,false);
//        officalToIntermediary.reverse().write(Paths.get("F:\\IDEAProjects\\SpecialSource\\intermediary-official.tsrg"),Format.TSRG,false);
//        intermediaryToYarn.write(Paths.get("F:\\IDEAProjects\\MITE1.18\\deofficial\\yarn-intermediary.tsrg"),Format.TSRG,true);

//        lambdas.chain(intermediaryToYarn.reverse()).chain(officialToIntermediary.reverse()).write(Paths.get("F:\\IDEAProjects\\SpecialSource\\lambda_yarn-official.tiny"),Format.TINY,false);

//        IMappingFile lambda_yarnToIntermediary = IMappingFile.load(Files.newInputStream(Paths.get("F:\\IDEAProjects\\SpecialSource\\lambda_yarn-intermediary.tiny")));
//        lambda_yarnToIntermediary.merge(intermediaryToYarn.reverse()).chain(intermediaryToOffical).write(Paths.get("F:\\IDEAProjects\\SpecialSource\\lambda_yarn-official.tiny"),Format.TINY,false);
//        intermediaryToYarn.reverse().removeAllOriginal(lambdas).write(new File("F:\\IDEAProjects\\MITE1.18\\deofficial\\offical-yarn_nolambda.tsrg").toPath(),Format.TSRG,false);
//        officialToIntermediary.chain(intermediaryToYarn).write(Paths.get("F:\\IDEAProjects\\MITE1.18\\deofficial\\offical-yarn.tsrg"),Format.TSRG,false);

//        IMappingFile yarnMappings = IMappingFile.load(new File("D:\\IDEAProjects\\MITE1.18.2\\deofficial\\mappings-base.tiny"));
//        IMappingFile srgToYarn = IMappingFile.load(new File("D:\\IDEAProjects\\MITE1.18.2\\deofficial\\mappings-srg-named.srg"));
//        try (FileWriter fileWriter = new FileWriter("D:\\IDEAProjects\\MITE1.18.2\\deofficial\\mcp_yarn-1.18.2-3-final.exc")) {
//            for (IMappingFile.IClass aClass : yarnMappings.chain(srgToYarn.reverse()).getClasses()) {
//                for (IMappingFile.IMethod method : aClass.getMethods()) {
//                    if (!method.getParameters().isEmpty()){
//                        StringBuilder s = new StringBuilder(aClass.getMapped() + "." + method.getMapped() + method.getMappedDescriptor() + "=|");
//                        for (IMappingFile.IParameter parameter : method.getParameters()) {
//                            s.append(parameter.getMapped()).append(",");
//                        }
//                        fileWriter.write(s.substring(0, s.length() - 1));
//                        fileWriter.write("\n");
//                    }
//                }
//            }
//        }
//        mcpToOfficial.chain(officalToIntermediary).chain(intermediaryToYarn).write(new File("D:\\IDEAProjects\\MITE1.18\\deofficial\\Chained.tsrg").toPath(),Format.TSRG,false);

    }

    @Test
    void reverse() throws IOException {
        IMappingFile a = INamedMappingFile.load(getStream("./installer.pg")).getMap("right", "left");
        IMappingFile b = INamedMappingFile.load(getStream("./installer.pg")).getMap("left", "right").reverse();
        a.getClasses().forEach(ca -> {
            IMappingFile.IClass cb = b.getClass(ca.getOriginal());
            Assertions.assertNotNull(cb, "Could not find class: " + ca);
            ca.getFields().forEach(fa -> {
                IMappingFile.IField fb = cb.getField(fa.getOriginal());
                Assertions.assertNotNull(fb, "Could not find field: " + fa);
                Assertions.assertEquals(fa.getMapped(), fb.getMapped(), "Fields did not match: " + fa + "{" + fa.getMapped() + " -> " + fb.getMapped() + "}");
            });
            ca.getMethods().forEach(ma -> {
                IMappingFile.IMethod mb = cb.getMethod(ma.getOriginal(), ma.getDescriptor());
                if (mb == null) {
                    //Assertions.assertNotNull(mb, "Could not find method: " + ma);
                    StringBuilder buf = new StringBuilder();
                    buf.append("Could not find method: " + ma);
                    cb.getMethods().forEach(m -> {
                        buf.append("\n  ").append(m.toString());
                    });
                    throw new IllegalArgumentException(buf.toString());
                }
                Assertions.assertEquals(ma.getMapped(), mb.getMapped(), "Methods did not match: " + ma + "{" + ma.getMapped() + " -> " + mb.getMapped() + "}");
                Assertions.assertEquals(ma.getMappedDescriptor(), mb.getMappedDescriptor(), "Method descriptors did not match: " + ma + "{" + ma.getMappedDescriptor() + " -> " + mb.getMappedDescriptor() + "}");
            });
        });
    }
}
