package com.neopragma.cobolcheck.features.testSuiteParser;

import java.util.ArrayList;
import java.util.List;

public class Mock {
    private String identifier;
    private String type;
    private List<String> lines;
    private MockScope scope;
    private boolean isUsed;
    private String testSuiteName;
    private String testCaseName;
    private int testSuiteNumber;
    private int testCaseNumber;
    private int mockNumber;

    public Mock(String testSuiteName, String testCaseName, int testSuiteNumber, int testCaseNumber, int mockNumber) {
        this.testSuiteName = testSuiteName;
        this.testCaseName = testCaseName;
        this.testSuiteNumber = testSuiteNumber;
        this.testCaseNumber = testCaseNumber;
        this.mockNumber = mockNumber;
        lines = new ArrayList<>();
    }

    public String getGeneratedMockIdentifier(){
        return testSuiteNumber + "-" + testCaseNumber + "-" + mockNumber + "-MOCK";
    }

    public String getGeneratedMockCountIdentifier(){
        return "UT-" + getGeneratedMockIdentifier() + "-COUNT";
    }

    public String getGeneratedMockCountExpectedIdentifier(){
        return "UT-" + getGeneratedMockIdentifier() + "-EXPECTED";
    }

    public String getGeneratedMockStringIdentifierName(){
        return "UT-" + getGeneratedMockIdentifier() + "-NAME";
    }

    public String getMockDisplayString(){
        return type.toUpperCase() + " " + identifier;
    }

    public String getMockDescription(){
        return type + " " + identifier + " in testsuite: " + testSuiteName +
                (testCaseName.equals("") ? "" : ", testcase: " + testCaseName);
    }

    public List<String> getCommentText(){
        List<String> lines = new ArrayList<>();
        lines.add("      *****************************************************************");
        lines.add(scope.name() + " mock of: " + type + ": " + identifier);
        lines.add("In testsuite: " + testSuiteName);
        if (scope == MockScope.Local){
            lines.add("In testcase: " + testCaseName);
        }
        lines.add("      *****************************************************************");
        return lines;

    }

    public String getIdentifier() {
        return identifier;
    }

    public String getType() {
        return type;
    }

    public List<String> getLines() {
        return lines;
    }

    public MockScope getScope() {
        return scope;
    }

    public boolean isUsed() {
        return isUsed;
    }

    public String getTestSuiteName() {
        return testSuiteName;
    }

    public String getTestCaseName() {
        return testCaseName;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setScope(MockScope scope) {
        this.scope = scope;
    }

    public void markAsUsed() {
        isUsed = true;
    }

    public void addLine(String line) {
        lines.add(line);
    }

    public void addLines(List<String> lines) {
        this.lines.addAll(lines);
    }
}
