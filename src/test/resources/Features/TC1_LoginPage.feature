Feature: Verify Para Bank login Details

  Scenario Outline: Verifying Para Bank login with valid data
    Given User is on the para bank  page
    When User should enter the "<username>" and "<password>"
    Then User should verify after login success message "Welcome Gopinath K"

    Examples: 
      | username     | password   |
      | Gopinath1894 | Gopiwin.94 |
