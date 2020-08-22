Feature: User registration
@fail
  Scenario: Registering  a single  user
    Given I am on homepage
    When I click on sign in button
    And I enter a valid email
    Then I should be able to register with the following details
      | First name | Last name | Password | Address              | City       | Zip   | Phone no   |
      | Joe        | Biden     | jbiden   | 1 Observatory Circle | Washington | 20000 | 2026666666 |


  Scenario Outline: Registering  multiple  users
    Given I am on homepage
    When I click on sign in button
    And I enter a valid email
    Then I should be able to register with the following details
      | First name   | Last name   | Password   | Address   | City   | Zip   | Phone no |
      | <first name> | <last name> | <password> | <address> | <city> | <zip> | <phone>  |

    Examples: 
      | first name | last name   | password     | address               | city              | zip   | phone        |
      | Skipton    | Dutchburn   | TOSswvBfyb   | 84 East Pass          | Romagueraborough  | 86475-000 | 761-920-2631 |
      | Peggi      | Handmore    | pGwiEmlZJ    | 6 Shoshone Point      | Port Sean         | 76317 | 703-746-6584 |
      | Gilli      | Dumbreck    | fRnPCsxGj1   | 74 Duke Place         | New Maplemouth    | 01634 | 377-762-0939 |
      | Alie       | Ashwell     | b2JeV7gPe    | 0 Texas Crossing      | Kelliefurt        | 00201 | 326-772-8875 |
      | Ethelbert  | Henken      | ByviTapC     | 238 Sutteridge Plaza  | Fidelburgh        | 20235 | 356-652-2766 |
      | Alan       | Lammin      | IQIylXW      | 5018 Carberry Pass    | North Kory        | 98411 | 911-342-4579 |
      | Lydia      | Kubasiewicz | VI7vgV1zXxsb | 6606 Pierstorff Way   | Greenshire        | 60882 | 685-603-9490 |
      | Lissy      | Honnan      | WfzYum       | 87183 Moose Avenue    | Tashamouth        | 13294 | 832-389-5938 |
      | Brewer     | Wylie       | qem3p8EFjO   | 1197 Browning Trail   | McLaughlinmouth   | 09835 | 586-720-7136 |
      | Archibald  | Dare        | fNKa9JTAUd   | 666 Dennis Junction   | Tromptown         | 93685 | 291-984-3430 |
      | Eleni      | Everingham  | ot0nwZdaIE65 | 14 Scofield Road      | West Grant        | 44064 | 234-572-6100 |
      | Othelia    | Vasilevich  | Ebtaarwm     | 2 Killdeer Plaza      | Theoview          | 76874 | 758-429-0575 |
      | Judah      | Tall        | 9kOAd5OmdQ   | 8794 Thierer Drive    | Pricetown         | 61040 | 914-366-0885 |
      | Dunc       | Dizlie      | gO7GRVXmPv6A | 5738 Pepper Wood Park | North Lyndonhaven | 90377 | 538-109-8375 |
      | Kelli      | Egdal       | 7uPjXaLRP    | 874 Havey Center      | West Williamside  | 03907 | 610-478-7624 |
