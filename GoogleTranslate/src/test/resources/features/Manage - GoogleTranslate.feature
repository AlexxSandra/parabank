Feature: GoogleTranslate

 Scenario: Verify Get response
  Given The following API endpoind "https://translate.google.com/"
  When GET request is sent
  Then the response Status 200 displayed
  And response body contains the following text "<!doctype html><html lang=\"en-US\" dir=\"ltr\">"