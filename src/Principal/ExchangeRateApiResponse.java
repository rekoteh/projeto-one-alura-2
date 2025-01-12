package Principal;

import java.util.Map;

public class ExchangeRateApiResponse {
    private String result;
    private String documentation;
    private String termsOfUse;
    private Long lastTimeUpdateUnix;
    private String lastNextUpdateUtc;
    private String baseCode;
    private Map<String, Double> conversionRates;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getDocumentation() {
        return documentation;
    }

    public void setDocumentation(String documentation) {
        this.documentation = documentation;
    }

    public String getTermsOfUse() {
        return termsOfUse;
    }

    public void setTermsOfUse(String termsOfUse) {
        this.termsOfUse = termsOfUse;
    }

    public Long getLastTimeUpdateUnix() {
        return lastTimeUpdateUnix;
    }

    public void setLastTimeUpdateUnix(Long lastTimeUpdateUnix) {
        this.lastTimeUpdateUnix = lastTimeUpdateUnix;
    }

    public String getLastNextUpdateUtc() {
        return lastNextUpdateUtc;
    }

    public void setLastNextUpdateUtc(String lastNextUpdateUtc) {
        this.lastNextUpdateUtc = lastNextUpdateUtc;
    }

    public String getBaseCode() {
        return baseCode;
    }

    public void setBaseCode(String baseCode) {
        this.baseCode = baseCode;
    }

    public Map<String, Double> getConversionRates() {
        return conversionRates;
    }

    public void setConversionRates(Map<String, Double> conversionRates) {
        this.conversionRates = conversionRates;
    }
}

