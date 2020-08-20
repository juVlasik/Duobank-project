Feature: Shopping cart


  Scenario Outline: Verify Shopping cart
    Given I am on homepage
    When I click on "<product>"
    And when I increase the quantity to <quantity> and add to cart and proceed to checkout
    Then I verify the following details of the cart and prices should be correct
      | <product> | <unit price> | <quantity> |

    Examples: 
      | product                     | unit price | quantity |
      | Faded Short Sleeve T-shirts |      16.51 |        3 |
      | Blouse                      |      27.00 |        6 |
      | Printed Dress               |      26.00 |        9 |
      | Printed Summer Dress        |      28.98 |       30 |
      | Printed Chiffon Dress       |      16.40 |       99 |
