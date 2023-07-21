import http from 'k6/http';
import { sleep } from 'k6';

export let options = {
    vus: 1000, // Virtual Users
    duration: '5s', // 테스트 지속 시간
};

export default function () {
    const response = http.get('http://YOUR_URL');

    if (response.status === 200) {
        console.log('성공적인 응답입니다!');
    } else {
        console.log(`실패: HTTP ${response.status}`);
    }

    sleep(1);
}
