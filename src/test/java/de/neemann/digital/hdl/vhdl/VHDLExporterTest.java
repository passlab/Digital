package de.neemann.digital.hdl.vhdl;

import de.neemann.digital.core.NodeException;
import de.neemann.digital.core.element.Keys;
import de.neemann.digital.core.io.In;
import de.neemann.digital.core.io.Out;
import de.neemann.digital.core.wiring.Clock;
import de.neemann.digital.draw.elements.Circuit;
import de.neemann.digital.draw.elements.PinException;
import de.neemann.digital.draw.elements.VisualElement;
import de.neemann.digital.draw.library.ElementNotFoundException;
import de.neemann.digital.integration.ToBreakRunner;
import junit.framework.TestCase;

import java.io.IOException;

public class VHDLExporterTest extends TestCase {

    public void testXor() throws IOException, ElementNotFoundException, PinException, NodeException {
        ToBreakRunner br = new ToBreakRunner("dig/hdl/xor.dig");
        String vhdl = new VHDLExporter(br.getLibrary()).export(br.getCircuit()).toString();
        assertEquals("-- auto generated by Digital\n" +
                "\n" +
                "LIBRARY ieee;\n" +
                "USE ieee.std_logic_1164.all;\n" +
                "USE ieee.numeric_std.all;\n" +
                "\n" +
                "entity main is\n" +
                "  port (\n" +
                "    PORT_A: in std_logic;\n" +
                "    PORT_B: in std_logic;\n" +
                "    PORT_Y: out std_logic );\n" +
                "end main;\n" +
                "\n" +
                "architecture main_arch of main is\n" +
                "\n" +
                "  component AND_GATE_2\n" +
                "    port (\n" +
                "      PORT_out: out std_logic;\n" +
                "      PORT_In_1: in std_logic;\n" +
                "      PORT_In_2: in std_logic );\n" +
                "  end component;\n" +
                "\n" +
                "  component OR_GATE_2\n" +
                "    port (\n" +
                "      PORT_out: out std_logic;\n" +
                "      PORT_In_1: in std_logic;\n" +
                "      PORT_In_2: in std_logic );\n" +
                "  end component;\n" +
                "\n" +
                "  component NOT_GATE\n" +
                "    port (\n" +
                "      PORT_out: out std_logic;\n" +
                "      PORT_in: in std_logic );\n" +
                "  end component;\n" +
                "\n" +
                "  signal S0: std_logic;\n" +
                "  signal S1: std_logic;\n" +
                "  signal S2: std_logic;\n" +
                "  signal S3: std_logic;\n" +
                "begin\n" +
                "  gate0 : AND_GATE_2\n" +
                "    port map (\n" +
                "      PORT_out => S1,\n" +
                "      PORT_In_1 => S0,\n" +
                "      PORT_In_2 => PORT_B );\n" +
                "  gate1 : AND_GATE_2\n" +
                "    port map (\n" +
                "      PORT_out => S3,\n" +
                "      PORT_In_1 => PORT_A,\n" +
                "      PORT_In_2 => S2 );\n" +
                "  gate2 : OR_GATE_2\n" +
                "    port map (\n" +
                "      PORT_out => PORT_Y,\n" +
                "      PORT_In_1 => S1,\n" +
                "      PORT_In_2 => S3 );\n" +
                "  gate3 : NOT_GATE\n" +
                "    port map (\n" +
                "      PORT_out => S2,\n" +
                "      PORT_in => PORT_B );\n" +
                "  gate4 : NOT_GATE\n" +
                "    port map (\n" +
                "      PORT_out => S0,\n" +
                "      PORT_in => PORT_A );\n" +
                "end main_arch;\n" +
                "\n" +
                "-- library components\n" +
                "\n" +
                "-- AND_GATE_2\n" +
                "\n" +
                "LIBRARY ieee;\n" +
                "USE ieee.std_logic_1164.all;\n" +
                "\n" +
                "entity AND_GATE_2 is\n" +
                "  port (\n" +
                "    PORT_out: out std_logic;\n" +
                "    PORT_In_1: in std_logic;\n" +
                "    PORT_In_2: in std_logic );\n" +
                "end AND_GATE_2;\n" +
                "\n" +
                "architecture AND_GATE_2_arch of AND_GATE_2 is\n" +
                "begin\n" +
                "  PORT_out <= PORT_In_1 AND PORT_In_2;\n" +
                "end AND_GATE_2_arch;\n" +
                "\n" +
                "-- OR_GATE_2\n" +
                "\n" +
                "LIBRARY ieee;\n" +
                "USE ieee.std_logic_1164.all;\n" +
                "\n" +
                "entity OR_GATE_2 is\n" +
                "  port (\n" +
                "    PORT_out: out std_logic;\n" +
                "    PORT_In_1: in std_logic;\n" +
                "    PORT_In_2: in std_logic );\n" +
                "end OR_GATE_2;\n" +
                "\n" +
                "architecture OR_GATE_2_arch of OR_GATE_2 is\n" +
                "begin\n" +
                "  PORT_out <= PORT_In_1 OR PORT_In_2;\n" +
                "end OR_GATE_2_arch;\n" +
                "\n" +
                "-- NOT_GATE\n" +
                "\n" +
                "LIBRARY ieee;\n" +
                "USE ieee.std_logic_1164.all;\n" +
                "\n" +
                "entity NOT_GATE is\n" +
                "  port (\n" +
                "    PORT_out: out std_logic;\n" +
                "    PORT_in: in std_logic );\n" +
                "end NOT_GATE;\n" +
                "\n" +
                "architecture NOT_GATE_arch of NOT_GATE is\n" +
                "begin\n" +
                "  PORT_out <=  NOT( PORT_in );\n" +
                "end NOT_GATE_arch;\n", vhdl);
    }

    public void testXorNeg() throws IOException, ElementNotFoundException, PinException, NodeException {
        ToBreakRunner br = new ToBreakRunner("dig/hdl/xorNeg.dig");
        String vhdl = new VHDLExporter(br.getLibrary()).export(br.getCircuit()).toString();
        assertEquals("-- auto generated by Digital\n" +
                "\n" +
                "LIBRARY ieee;\n" +
                "USE ieee.std_logic_1164.all;\n" +
                "USE ieee.numeric_std.all;\n" +
                "\n" +
                "entity main is\n" +
                "  port (\n" +
                "    PORT_A: in std_logic;\n" +
                "    PORT_B: in std_logic;\n" +
                "    PORT_Y: out std_logic );\n" +
                "end main;\n" +
                "\n" +
                "architecture main_arch of main is\n" +
                "\n" +
                "  component AND_GATE_2\n" +
                "    port (\n" +
                "      PORT_out: out std_logic;\n" +
                "      PORT_In_1: in std_logic;\n" +
                "      PORT_In_2: in std_logic );\n" +
                "  end component;\n" +
                "\n" +
                "  component OR_GATE_2\n" +
                "    port (\n" +
                "      PORT_out: out std_logic;\n" +
                "      PORT_In_1: in std_logic;\n" +
                "      PORT_In_2: in std_logic );\n" +
                "  end component;\n" +
                "\n" +
                "  component NOT_GATE\n" +
                "    port (\n" +
                "      PORT_out: out std_logic;\n" +
                "      PORT_in: in std_logic );\n" +
                "  end component;\n" +
                "\n" +
                "  signal PORT_A_Neg: std_logic;\n" +
                "  signal PORT_B_Neg: std_logic;\n" +
                "  signal S0: std_logic;\n" +
                "  signal S1: std_logic;\n" +
                "begin\n" +
                "  gate0 : AND_GATE_2\n" +
                "    port map (\n" +
                "      PORT_out => S0,\n" +
                "      PORT_In_1 => PORT_A_Neg,\n" +
                "      PORT_In_2 => PORT_B );\n" +
                "  gate1 : AND_GATE_2\n" +
                "    port map (\n" +
                "      PORT_out => S1,\n" +
                "      PORT_In_1 => PORT_A,\n" +
                "      PORT_In_2 => PORT_B_Neg );\n" +
                "  gate2 : OR_GATE_2\n" +
                "    port map (\n" +
                "      PORT_out => PORT_Y,\n" +
                "      PORT_In_1 => S0,\n" +
                "      PORT_In_2 => S1 );\n" +
                "  gate3 : NOT_GATE\n" +
                "    port map (\n" +
                "      PORT_out => PORT_A_Neg,\n" +
                "      PORT_in => PORT_A );\n" +
                "  gate4 : NOT_GATE\n" +
                "    port map (\n" +
                "      PORT_out => PORT_B_Neg,\n" +
                "      PORT_in => PORT_B );\n" +
                "end main_arch;\n" +
                "\n" +
                "-- library components\n" +
                "\n" +
                "-- AND_GATE_2\n" +
                "\n" +
                "LIBRARY ieee;\n" +
                "USE ieee.std_logic_1164.all;\n" +
                "\n" +
                "entity AND_GATE_2 is\n" +
                "  port (\n" +
                "    PORT_out: out std_logic;\n" +
                "    PORT_In_1: in std_logic;\n" +
                "    PORT_In_2: in std_logic );\n" +
                "end AND_GATE_2;\n" +
                "\n" +
                "architecture AND_GATE_2_arch of AND_GATE_2 is\n" +
                "begin\n" +
                "  PORT_out <= PORT_In_1 AND PORT_In_2;\n" +
                "end AND_GATE_2_arch;\n" +
                "\n" +
                "-- OR_GATE_2\n" +
                "\n" +
                "LIBRARY ieee;\n" +
                "USE ieee.std_logic_1164.all;\n" +
                "\n" +
                "entity OR_GATE_2 is\n" +
                "  port (\n" +
                "    PORT_out: out std_logic;\n" +
                "    PORT_In_1: in std_logic;\n" +
                "    PORT_In_2: in std_logic );\n" +
                "end OR_GATE_2;\n" +
                "\n" +
                "architecture OR_GATE_2_arch of OR_GATE_2 is\n" +
                "begin\n" +
                "  PORT_out <= PORT_In_1 OR PORT_In_2;\n" +
                "end OR_GATE_2_arch;\n" +
                "\n" +
                "-- NOT_GATE\n" +
                "\n" +
                "LIBRARY ieee;\n" +
                "USE ieee.std_logic_1164.all;\n" +
                "\n" +
                "entity NOT_GATE is\n" +
                "  port (\n" +
                "    PORT_out: out std_logic;\n" +
                "    PORT_in: in std_logic );\n" +
                "end NOT_GATE;\n" +
                "\n" +
                "architecture NOT_GATE_arch of NOT_GATE is\n" +
                "begin\n" +
                "  PORT_out <=  NOT( PORT_in );\n" +
                "end NOT_GATE_arch;\n", vhdl);
    }

    public void testNeg() throws IOException, ElementNotFoundException, PinException, NodeException {
        ToBreakRunner br = new ToBreakRunner("dig/hdl/neg.dig");
        String vhdl = new VHDLExporter(br.getLibrary()).export(br.getCircuit()).toString();
        assertEquals("-- auto generated by Digital\n" +
                "\n" +
                "LIBRARY ieee;\n" +
                "USE ieee.std_logic_1164.all;\n" +
                "USE ieee.numeric_std.all;\n" +
                "\n" +
                "entity main is\n" +
                "  port (\n" +
                "    PORT_A: in std_logic;\n" +
                "    PORT_Y: out std_logic );\n" +
                "end main;\n" +
                "\n" +
                "architecture main_arch of main is\n" +
                "\n" +
                "  component OR_GATE_2\n" +
                "    port (\n" +
                "      PORT_out: out std_logic;\n" +
                "      PORT_In_1: in std_logic;\n" +
                "      PORT_In_2: in std_logic );\n" +
                "  end component;\n" +
                "\n" +
                "  component NOT_GATE\n" +
                "    port (\n" +
                "      PORT_out: out std_logic;\n" +
                "      PORT_in: in std_logic );\n" +
                "  end component;\n" +
                "\n" +
                "  signal PORT_A_Neg: std_logic;\n" +
                "begin\n" +
                "  gate0 : OR_GATE_2\n" +
                "    port map (\n" +
                "      PORT_out => PORT_Y,\n" +
                "      PORT_In_1 => PORT_A_Neg,\n" +
                "      PORT_In_2 => PORT_A_Neg );\n" +
                "  gate1 : NOT_GATE\n" +
                "    port map (\n" +
                "      PORT_out => PORT_A_Neg,\n" +
                "      PORT_in => PORT_A );\n" +
                "end main_arch;\n" +
                "\n" +
                "-- library components\n" +
                "\n" +
                "-- OR_GATE_2\n" +
                "\n" +
                "LIBRARY ieee;\n" +
                "USE ieee.std_logic_1164.all;\n" +
                "\n" +
                "entity OR_GATE_2 is\n" +
                "  port (\n" +
                "    PORT_out: out std_logic;\n" +
                "    PORT_In_1: in std_logic;\n" +
                "    PORT_In_2: in std_logic );\n" +
                "end OR_GATE_2;\n" +
                "\n" +
                "architecture OR_GATE_2_arch of OR_GATE_2 is\n" +
                "begin\n" +
                "  PORT_out <= PORT_In_1 OR PORT_In_2;\n" +
                "end OR_GATE_2_arch;\n" +
                "\n" +
                "-- NOT_GATE\n" +
                "\n" +
                "LIBRARY ieee;\n" +
                "USE ieee.std_logic_1164.all;\n" +
                "\n" +
                "entity NOT_GATE is\n" +
                "  port (\n" +
                "    PORT_out: out std_logic;\n" +
                "    PORT_in: in std_logic );\n" +
                "end NOT_GATE;\n" +
                "\n" +
                "architecture NOT_GATE_arch of NOT_GATE is\n" +
                "begin\n" +
                "  PORT_out <=  NOT( PORT_in );\n" +
                "end NOT_GATE_arch;\n", vhdl);
    }

    public void testXorNegBus() throws IOException, ElementNotFoundException, PinException, NodeException {
        ToBreakRunner br = new ToBreakRunner("dig/hdl/xorNegBus.dig");
        String vhdl = new VHDLExporter(br.getLibrary()).export(br.getCircuit()).toString();
        assertEquals("-- auto generated by Digital\n" +
                "\n" +
                "LIBRARY ieee;\n" +
                "USE ieee.std_logic_1164.all;\n" +
                "USE ieee.numeric_std.all;\n" +
                "\n" +
                "entity main is\n" +
                "  port (\n" +
                "    PORT_A: in std_logic_vector (1 downto 0);\n" +
                "    PORT_B: in std_logic_vector (1 downto 0);\n" +
                "    PORT_Y: out std_logic_vector (1 downto 0) );\n" +
                "end main;\n" +
                "\n" +
                "architecture main_arch of main is\n" +
                "\n" +
                "  component AND_GATE_BUS_2\n" +
                "    generic ( bitCount : integer );\n" +
                "    port (\n" +
                "      PORT_out: out std_logic_vector ((bitCount-1) downto 0);\n" +
                "      PORT_In_1: in std_logic_vector ((bitCount-1) downto 0);\n" +
                "      PORT_In_2: in std_logic_vector ((bitCount-1) downto 0) );\n" +
                "  end component;\n" +
                "\n" +
                "  component OR_GATE_BUS_2\n" +
                "    generic ( bitCount : integer );\n" +
                "    port (\n" +
                "      PORT_out: out std_logic_vector ((bitCount-1) downto 0);\n" +
                "      PORT_In_1: in std_logic_vector ((bitCount-1) downto 0);\n" +
                "      PORT_In_2: in std_logic_vector ((bitCount-1) downto 0) );\n" +
                "  end component;\n" +
                "\n" +
                "  component NOT_GATE_BUS\n" +
                "    generic ( bitCount : integer );\n" +
                "    port (\n" +
                "      PORT_out: out std_logic_vector ((bitCount-1) downto 0);\n" +
                "      PORT_in: in std_logic_vector ((bitCount-1) downto 0) );\n" +
                "  end component;\n" +
                "\n" +
                "  signal PORT_A_Neg: std_logic_vector (1 downto 0);\n" +
                "  signal PORT_B_Neg: std_logic_vector (1 downto 0);\n" +
                "  signal S0: std_logic_vector (1 downto 0);\n" +
                "  signal S1: std_logic_vector (1 downto 0);\n" +
                "begin\n" +
                "  gate0 : AND_GATE_BUS_2\n" +
                "    generic map ( bitCount => 2)\n" +
                "    port map (\n" +
                "      PORT_out => S0,\n" +
                "      PORT_In_1 => PORT_A_Neg,\n" +
                "      PORT_In_2 => PORT_B );\n" +
                "  gate1 : AND_GATE_BUS_2\n" +
                "    generic map ( bitCount => 2)\n" +
                "    port map (\n" +
                "      PORT_out => S1,\n" +
                "      PORT_In_1 => PORT_A,\n" +
                "      PORT_In_2 => PORT_B_Neg );\n" +
                "  gate2 : OR_GATE_BUS_2\n" +
                "    generic map ( bitCount => 2)\n" +
                "    port map (\n" +
                "      PORT_out => PORT_Y,\n" +
                "      PORT_In_1 => S0,\n" +
                "      PORT_In_2 => S1 );\n" +
                "  gate3 : NOT_GATE_BUS\n" +
                "    generic map ( bitCount => 2)\n" +
                "    port map (\n" +
                "      PORT_out => PORT_A_Neg,\n" +
                "      PORT_in => PORT_A );\n" +
                "  gate4 : NOT_GATE_BUS\n" +
                "    generic map ( bitCount => 2)\n" +
                "    port map (\n" +
                "      PORT_out => PORT_B_Neg,\n" +
                "      PORT_in => PORT_B );\n" +
                "end main_arch;\n" +
                "\n" +
                "-- library components\n" +
                "\n" +
                "-- AND_GATE_BUS_2\n" +
                "\n" +
                "LIBRARY ieee;\n" +
                "USE ieee.std_logic_1164.all;\n" +
                "\n" +
                "entity AND_GATE_BUS_2 is\n" +
                "  generic ( bitCount : integer );\n" +
                "  port (\n" +
                "    PORT_out: out std_logic_vector ((bitCount-1) downto 0);\n" +
                "    PORT_In_1: in std_logic_vector ((bitCount-1) downto 0);\n" +
                "    PORT_In_2: in std_logic_vector ((bitCount-1) downto 0) );\n" +
                "end AND_GATE_BUS_2;\n" +
                "\n" +
                "architecture AND_GATE_BUS_2_arch of AND_GATE_BUS_2 is\n" +
                "begin\n" +
                "  PORT_out <= PORT_In_1 AND PORT_In_2;\n" +
                "end AND_GATE_BUS_2_arch;\n" +
                "\n" +
                "-- OR_GATE_BUS_2\n" +
                "\n" +
                "LIBRARY ieee;\n" +
                "USE ieee.std_logic_1164.all;\n" +
                "\n" +
                "entity OR_GATE_BUS_2 is\n" +
                "  generic ( bitCount : integer );\n" +
                "  port (\n" +
                "    PORT_out: out std_logic_vector ((bitCount-1) downto 0);\n" +
                "    PORT_In_1: in std_logic_vector ((bitCount-1) downto 0);\n" +
                "    PORT_In_2: in std_logic_vector ((bitCount-1) downto 0) );\n" +
                "end OR_GATE_BUS_2;\n" +
                "\n" +
                "architecture OR_GATE_BUS_2_arch of OR_GATE_BUS_2 is\n" +
                "begin\n" +
                "  PORT_out <= PORT_In_1 OR PORT_In_2;\n" +
                "end OR_GATE_BUS_2_arch;\n" +
                "\n" +
                "-- NOT_GATE_BUS\n" +
                "\n" +
                "LIBRARY ieee;\n" +
                "USE ieee.std_logic_1164.all;\n" +
                "\n" +
                "entity NOT_GATE_BUS is\n" +
                "  generic ( bitCount : integer );\n" +
                "  port (\n" +
                "    PORT_out: out std_logic_vector ((bitCount-1) downto 0);\n" +
                "    PORT_in: in std_logic_vector ((bitCount-1) downto 0) );\n" +
                "end NOT_GATE_BUS;\n" +
                "\n" +
                "architecture NOT_GATE_BUS_arch of NOT_GATE_BUS is\n" +
                "begin\n" +
                "  PORT_out <=  NOT( PORT_in );\n" +
                "end NOT_GATE_BUS_arch;\n", vhdl);
    }

    public void testIdent() throws IOException, ElementNotFoundException, PinException, NodeException {
        ToBreakRunner br = new ToBreakRunner("dig/hdl/ident.dig");
        String vhdl = new VHDLExporter(br.getLibrary()).export(br.getCircuit()).toString();
        assertEquals("-- auto generated by Digital\n" +
                "\n" +
                "LIBRARY ieee;\n" +
                "USE ieee.std_logic_1164.all;\n" +
                "USE ieee.numeric_std.all;\n" +
                "\n" +
                "entity main is\n" +
                "  port (\n" +
                "    PORT_A: in std_logic;\n" +
                "    PORT_Y: out std_logic;\n" +
                "    PORT_Z: out std_logic );\n" +
                "end main;\n" +
                "\n" +
                "architecture main_arch of main is\n" +
                "\n" +
                "begin\n" +
                "  PORT_Y <= PORT_A;\n" +
                "  PORT_Z <= PORT_A;\n" +
                "end main_arch;\n" +
                "\n" +
                "-- library components\n", vhdl);
   }

    public void testNestedAnd() throws IOException, ElementNotFoundException, PinException, NodeException {
        ToBreakRunner br = new ToBreakRunner("dig/nestedAnd.dig");
        String vhdl = new VHDLExporter(br.getLibrary()).export(br.getCircuit()).toString();
        assertEquals("-- auto generated by Digital\n" +
                "\n" +
                "LIBRARY ieee;\n" +
                "USE ieee.std_logic_1164.all;\n" +
                "USE ieee.numeric_std.all;\n" +
                "\n" +
                "entity main is\n" +
                "  port (\n" +
                "    PORT_A: in std_logic;\n" +
                "    PORT_B: in std_logic;\n" +
                "    PORT_C: out std_logic );\n" +
                "end main;\n" +
                "\n" +
                "architecture main_arch of main is\n" +
                "\n" +
                "  component and_dig\n" +
                "    port (\n" +
                "      PORT_Out: out std_logic;\n" +
                "      PORT_A: in std_logic;\n" +
                "      PORT_B: in std_logic );\n" +
                "  end component;\n" +
                "\n" +
                "begin\n" +
                "  gate0 : and_dig\n" +
                "    port map (\n" +
                "      PORT_Out => PORT_C,\n" +
                "      PORT_A => PORT_A,\n" +
                "      PORT_B => PORT_B );\n" +
                "end main_arch;\n" +
                "\n" +
                "-- and_dig\n" +
                "\n" +
                "LIBRARY ieee;\n" +
                "USE ieee.std_logic_1164.all;\n" +
                "USE ieee.numeric_std.all;\n" +
                "\n" +
                "entity and_dig is\n" +
                "  port (\n" +
                "    PORT_A: in std_logic;\n" +
                "    PORT_B: in std_logic;\n" +
                "    PORT_Out: out std_logic );\n" +
                "end and_dig;\n" +
                "\n" +
                "architecture and_dig_arch of and_dig is\n" +
                "\n" +
                "  component AND_GATE_2\n" +
                "    port (\n" +
                "      PORT_out: out std_logic;\n" +
                "      PORT_In_1: in std_logic;\n" +
                "      PORT_In_2: in std_logic );\n" +
                "  end component;\n" +
                "\n" +
                "begin\n" +
                "  gate0 : AND_GATE_2\n" +
                "    port map (\n" +
                "      PORT_out => PORT_Out,\n" +
                "      PORT_In_1 => PORT_A,\n" +
                "      PORT_In_2 => PORT_B );\n" +
                "end and_dig_arch;\n" +
                "\n" +
                "-- library components\n" +
                "\n" +
                "-- AND_GATE_2\n" +
                "\n" +
                "LIBRARY ieee;\n" +
                "USE ieee.std_logic_1164.all;\n" +
                "\n" +
                "entity AND_GATE_2 is\n" +
                "  port (\n" +
                "    PORT_out: out std_logic;\n" +
                "    PORT_In_1: in std_logic;\n" +
                "    PORT_In_2: in std_logic );\n" +
                "end AND_GATE_2;\n" +
                "\n" +
                "architecture AND_GATE_2_arch of AND_GATE_2 is\n" +
                "begin\n" +
                "  PORT_out <= PORT_In_1 AND PORT_In_2;\n" +
                "end AND_GATE_2_arch;\n", vhdl);
    }

}