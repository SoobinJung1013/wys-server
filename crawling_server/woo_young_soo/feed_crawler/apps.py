from django.apps import AppConfig


class FeedCrawlerConfig(AppConfig):
    default_auto_field = 'django.db.models.BigAutoField'
    name = 'feed_crawler'

    def ready(self):
        print("scheduler ready")
        from apscheduler.schedulers.background import BackgroundScheduler
        from django_apscheduler.jobstores import DjangoJobStore

        job_store = DjangoJobStore()
        job_store.remove_all_jobs()

        scheduler = BackgroundScheduler()
        scheduler.add_jobstore(job_store, "default")
        scheduler.remove_all_jobs()

        from . import danawa_dog_feed, danawa_cat_feed
        scheduler.add_job(danawa_cat_feed.danawa_cat_feed,
                          "cron", minute='*/60', id="danawa_cat_feed")
        scheduler.add_job(danawa_dog_feed.danawa_dog_feed,
                          "cron", minute='*/60', id="danawa_dog_feed")
        scheduler.start()
