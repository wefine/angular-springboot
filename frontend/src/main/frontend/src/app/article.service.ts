import { Injectable } from '@angular/core';

import { Headers, Http, RequestOptions, Response, URLSearchParams } from '@angular/http';
import { Observable } from 'rxjs';

import { Article } from './article';


@Injectable()
export class ArticleService {
  private allArticlesUrl = 'api/articles';
  private articleUrl = 'api/article';

  //Create constructor to get Http instance
  constructor(private http: Http) {
  }

  //Fetch all articles
  getAllArticles(): Observable<Article[]> {
    return this.http.get(this.allArticlesUrl)
      .map(this.extractData)
      .catch(this.handleError);

  }

  //Create article
  createArticle(article: Article): Observable<number> {
    let cpHeaders = new Headers({'Content-Type': 'application/json'});
    let options = new RequestOptions({headers: cpHeaders});
    return this.http.post(this.articleUrl, article, options)
      .map(success => success.status)
      .catch(this.handleError);
  }

  //Fetch article by id
  getArticleById(articleId: string): Observable<Article> {
    let cpHeaders = new Headers({'Content-Type': 'application/json'});
    let cpParams = new URLSearchParams();
    cpParams.set('id', articleId);
    let options = new RequestOptions({headers: cpHeaders, params: cpParams});
    return this.http.get(this.articleUrl, options)
      .map(this.extractData)
      .catch(this.handleError);
  }

  //Update article
  updateArticle(article: Article): Observable<number> {
    let cpHeaders = new Headers({'Content-Type': 'application/json'});
    let options = new RequestOptions({headers: cpHeaders});
    return this.http.put(this.articleUrl, article, options)
      .map(success => success.status)
      .catch(this.handleError);
  }

  //Delete article
  deleteArticleById(articleId: string): Observable<number> {
    let cpHeaders = new Headers({'Content-Type': 'application/json'});
    let cpParams = new URLSearchParams();
    cpParams.set('id', articleId);
    let options = new RequestOptions({headers: cpHeaders, params: cpParams});
    return this.http.delete(this.articleUrl, options)
      .map(success => success.status)
      .catch(this.handleError);
  }

  private extractData(res: Response) {
    return res.json();
  }

  private handleError(error: Response | any) {
    console.error(error.message || error);
    return Observable.throw(error.status);
  }

}
