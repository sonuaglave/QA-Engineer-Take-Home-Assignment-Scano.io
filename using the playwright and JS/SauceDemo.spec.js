const { test, expect } = require('@playwright/test');

test('SauceDemo Complete Flow', async ({ page }) => {

  // Open Website
  await page.goto('https://www.saucedemo.com/');

  // Login
  await page.locator('#user-name')
    .fill('standard_user');

  await page.locator('#password')
    .fill('secret_sauce');

  await page.locator('#login-button')
    .click();

  // Verify Login
  await expect(page)
    .toHaveURL(/inventory/);

  // Add Product To Cart
  await page.locator(
    '#add-to-cart-sauce-labs-backpack'
  ).click();

  // Verify Cart Count
  await expect(
    page.locator('.shopping_cart_badge')
  ).toHaveText('1');

  // Open Cart
  await page.locator('.shopping_cart_link')
    .click();

  // Checkout
  await page.locator('#checkout')
    .click();

  // Enter Checkout Details
  await page.locator('#first-name')
    .fill('Sudarshan');

  await page.locator('#last-name')
    .fill('Aglave');

  await page.locator('#postal-code')
    .fill('411001');

  // Continue Checkout
  await page.locator('#continue')
    .click();

  // Finish Order
  await page.locator('#finish')
    .click();

  // Verify Success Message
  await expect(
    page.locator('.complete-header')
  ).toHaveText(
    'Thank you for your order!'
  );

  // Logout Flow
  await page.locator(
    '#react-burger-menu-btn'
  ).click();

  await page.locator(
    '#logout_sidebar_link'
  ).click();

  // Verify Logout
  await expect(
    page.locator('#login-button')
  ).toBeVisible();

});