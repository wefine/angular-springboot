import { AngularSpringbootPage } from './app.po';

describe('angular-springboot App', () => {
  let page: AngularSpringbootPage;

  beforeEach(() => {
    page = new AngularSpringbootPage();
  });

  it('should display welcome message', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('Welcome to app!!');
  });
});
