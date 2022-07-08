package com.etlservice.schedular.utils;

import java.util.HashMap;
import java.util.Map;

public class Regimen {

    public static String getRegimen(int valueCoded) {
        Map<Integer, String> regimenMap = new HashMap<>();
        //Adult Second Line
        regimenMap.put(817, "ABC-3TC-AZT");
        regimenMap.put(165526,"ABC-3TC-DDI");
        regimenMap.put(165691,"ABC-3TC-DTG");
        regimenMap.put(162563,"ABC-3TC-EFV");
        regimenMap.put(162199,"ABC-3TC-NVP");
        regimenMap.put(166181,"ABC-3TC-TDF");
        regimenMap.put(165692,"ABC-FTC-DTG");
        regimenMap.put(166179,"ABC-FTC-EFV");
        regimenMap.put(165690,"ABC-FTC-NVP");
        regimenMap.put(166187,"AZT-3TC-DTG");
        regimenMap.put(160124,"AZT-3TC-EFV");
        regimenMap.put(1652,"AZT-3TC-NVP");
        regimenMap.put(166185,"AZT-TDF-NVP");
        regimenMap.put(166183,"D4T-3TC-ABC");
        regimenMap.put(160104,"D4T-3TC-EFV");
        regimenMap.put(792,"D4T-3TC-NVP");
        regimenMap.put(166186,"DDI-3TC-EFV");
        regimenMap.put(165525,"DDI-3TC-NVP");
        regimenMap.put(165522,"TDF-3TC-AZT");
        regimenMap.put(165681,"TDF-3TC-DTG");
        regimenMap.put(164505,"TDF-3TC-EFV");
        regimenMap.put(162565,"TDF-3TC-NVP");
        regimenMap.put(165682,"TDF-FTC-DTG");
        regimenMap.put(104565,"TDF-FTC-EFV");
        regimenMap.put(164854,"TDF-FTC-NVP");

        //Adult Second Line
        regimenMap.put(166092,"ABC-3TC-ATV/r");
        regimenMap.put(162200,"ABC-3TC-LPV/r");
        regimenMap.put(162564,"ABC-AZT-LPV/r");
        regimenMap.put(162559,"ABC-DDI-LPV/r");
        regimenMap.put(165541,"ABC-DDI-SQV/r");
        regimenMap.put(164511,"AZT-3TC-ATV/r");
        regimenMap.put(166192,"AZT-3TC-DRV/r");
        regimenMap.put(165534,"AZT-3TC-IDV/r");
        regimenMap.put(162561,"AZT-3TC-LPV/r");
        regimenMap.put(165529,"AZT-3TC-SQV/r");
        regimenMap.put(166190,"D4T-3TC-IDV/r");
        regimenMap.put(162560,"D4T-3TC-LPV/r");
        regimenMap.put(166191,"DDI-3TC-IND/r");
        regimenMap.put(166188,"DDI-3TC-LPV/r");
        regimenMap.put(164512,"TDF-3TC-ATV/r");
        regimenMap.put(166193,"TDF-3TC-DRV/r");
        regimenMap.put(165533,"TDF-3TC-IDV/r");
        regimenMap.put(162201,"TDF-3TC-LPV/r");
        regimenMap.put(165528,"TDF-3TC-SQV/r");
        regimenMap.put(165537,"TDF-AZT-3TC-ATV/r");
        regimenMap.put(165542,"TDF-DDI-IDV/r");
        regimenMap.put(165524,"TDF-FTC-ATV/r");
        regimenMap.put(165539,"TDF-FTC-IDV/r");
        regimenMap.put(165523,"TDF-FTC-LPV/r");
        regimenMap.put(165527,"TDF-FTC-SQV/r");


        //Child Second Line
        regimenMap.put(165693,"ABC-3TC-EFV400");
        regimenMap.put(165694,"ABC-FTC-EFV400");
        regimenMap.put(165695,"AZT-3TC-RAL");
        regimenMap.put(165686,"TDF-3TC-EFV400");
        regimenMap.put(165687,"TDF-FTC-EFV400");

        //Adult Third Line
        regimenMap.put(166203,"ABC-3TC-AZT-ATV/r");
        regimenMap.put(166202,"ABC-3TC-AZT-EFV");
        regimenMap.put(166199,"ABC-3TC-AZT-LPV/r");
        regimenMap.put(166197,"ABC-3TC-DTG-ATV/r");
        regimenMap.put(166198,"ABC-3TC-DTG-DRV-RTV");
        regimenMap.put(166204,"ABC-3TC-LPV-ATV/r");
        regimenMap.put(165696,"ABC-3TC-RAL");
        regimenMap.put(166201,"AZT-3TC-LPV-ATV/r");
        regimenMap.put(166200,"AZT-3TC-LPV-SQV/r");
        regimenMap.put(165695,"AZT-3TC-RAL");
        regimenMap.put(166207,"AZT-RAL-ATV/r");
        regimenMap.put(165530,"AZT-TDF-3TC-LPV/r");
        regimenMap.put(165540,"AZT-TDF-FTC-LPV/r");
        regimenMap.put(166196,"TDF-3TC-DTG-DRV-RTV");
        regimenMap.put(166194,"TDF-3TC-DTG-LPV/r");
        regimenMap.put(166206,"TDF-3TC-RAL");
        regimenMap.put(165537,"TDF-AZT-3TC-ATV/r");
        regimenMap.put(165536,"TDF-AZT-3TC-IDV/r");
        regimenMap.put(165532,"TDF-AZT-3TC-SQV/r");
        regimenMap.put(165535,"TDF-AZT-FTC-IDV/r");
        regimenMap.put(165531,"TDF-AZT-FTC-SQV/r");
        regimenMap.put(166195,"TDF-FTC-AZT-ATV/r");
        regimenMap.put(166205,"TDF-FTC-LPV-ATV/r");

        //Child Third Line
        regimenMap.put(165698,"DRV/r + 2 NRTIs + 2 NNRTI");
        regimenMap.put(165700,"DRV/r +2NRTIs");
        regimenMap.put(165701,"DRV/r+RAL + 1-2NRTIs");
        regimenMap.put(165689,"DRV/r-2NRTIs + NNRTI");
        regimenMap.put(165688,"DRV/r-DTG + 1-2 NRTIs");
        regimenMap.put(165697,"DTG+2 NRTIs");
        regimenMap.put(165699,"RAL(or DTG) + 2 NRTIs");

        return regimenMap.get(valueCoded);
    }
}
