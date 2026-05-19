# SauceDemo.spec.js

## Run Tests

```bash
npx playwright test SauceDemo.spec.js
```

## Run in Headed Mode

```bash
npx playwright test SauceDemo.spec.js --headed
```

## Run Single Test

```bash
npx playwright test SauceDemo.spec.js --grep "login"
npx playwright test SauceDemo.spec.js --grep "cart"
npx playwright test SauceDemo.spec.js --grep "checkout"
```

## Test Cases

| #   | Test Name           | Description                          |
| --- | ------------------- | ------------------------------------ |
| 1   | Successful login    | Login with standard_user credentials |
| 2   | Add product to cart | Add Sauce Labs Backpack to cart      |
| 3   | Successful checkout | Complete purchase flow               |

## Credentials

- **URL:** https://www.saucedemo.com/
- **Username:** standard_user
- **Password:** secret_sauce
