/**
 * 안녕하세요, 두프룸프님! 이 파일은 게시글의 생성, 수정, 삭제와 같은
 * 클라이언트 사이드(브라우저)의 동적인 기능을 처리하는 자바스크립트 파일입니다.
 * 각 버튼에 이벤트 리스너를 추가하여, 사용자의 클릭에 반응하고 서버 API를 호출하는 역할을 합니다.
 */

/**
 * CSRF(Cross-Site Request Forgery) 토큰을 가져오는 함수입니다.
 * Spring Security는 CSRF 공격을 방지하기 위해 이 토큰을 사용합니다.
 * 서버에 데이터를 보내는 모든 '안전하지 않은' 요청(POST, PUT, DELETE 등)에는
 * 이 CSRF 토큰을 함께 보내야 정상적으로 처리됩니다.
 *
 * 이 함수는 HTML의 <meta> 태그에 저장된 CSRF 토큰 값과 헤더 이름을 읽어와 반환합니다.
 * 이 정보는 layout.html 또는 각 페이지의 <head> 부분에 설정되어 있어야 합니다.
 *
 * @returns {header, token} CSRF 헤더 이름과 토큰 값을 담은 객체
 */
function csrf() {
  const token = document.querySelector('meta[name="_csrf"]')?.content;
  const header = document.querySelector('meta[name="_csrf_header"]')?.content || 'X-CSRF-TOKEN';
  if (!token) console.warn('CSRF token not found in meta tags.');
  return { header, token };
}

// --- 게시글 생성 기능 ---
const createButton = document.getElementById('create-btn'); // '등록' 버튼 요소를 가져옵니다.

if (createButton) { // '등록' 버튼이 현재 페이지에 존재하는 경우에만 아래 로직을 실행합니다.
    createButton.addEventListener('click', async () => { // 버튼에 'click' 이벤트 리스너를 추가합니다.
        // 폼에 입력된 제목과 내용을 가져와 body 객체를 만듭니다.
        const body = {
            title: document.getElementById('title').value,
            content: document.getElementById('content').value
        };

        const { header, token } = csrf(); // CSRF 토큰 정보를 가져옵니다.

        try {
            // fetch API를 사용하여 서버의 생성 API('/api/articles')에 POST 요청을 보냅니다.
            const res = await fetch('/api/articles', {
              method: 'POST', // HTTP 메소드
              headers: {
                "Content-Type": "application/json", // 요청 본문의 타입은 JSON임을 명시합니다.
                ...(token ? { [header]: token } : {}) // CSRF 토큰이 있다면, 헤더에 추가합니다.
              },
              body: JSON.stringify(body), // 자바스크립트 객체를 JSON 문자열로 변환하여 요청 본문에 담습니다.
              credentials: 'same-origin' // 동일 출처(same-origin) 요청에 쿠키를 포함시킵니다. (로그인 세션 유지를 위해)
            });

            if (!res.ok) { // 응답 상태가 'ok'(200-299)가 아닌 경우
                const errorData = await res.json().catch(() => ({ message: '알 수 없는 오류' }));
                return alert('등록 실패: ' + (errorData.message || res.status));
            }

            alert('등록 완료되었습니다.');
            // 게시글 생성 성공 시, 게시글 목록 페이지로 이동합니다.
            location.replace('/articles');

        } catch (error) {
            console.error('Error creating article:', error);
            alert('등록 중 오류가 발생했습니다.');
        }
    });
}

// --- 게시글 삭제 기능 ---
const deleteButton = document.getElementById('delete-btn'); // '삭제' 버튼 요소를 가져옵니다.

if (deleteButton) { // '삭제' 버튼이 현재 페이지에 존재하는 경우
    deleteButton.addEventListener('click', async () => {
        const id = document.getElementById('article-id')?.value; // 숨겨진 input에서 게시글 ID를 가져옵니다.
        if (!id) return alert('id가 없습니다.');

        if (!confirm('정말로 삭제하시겠습니까?')) return; // 사용자에게 삭제 의사를 다시 한번 확인합니다.

        const { header, token } = csrf(); // CSRF 토큰 정보를 가져옵니다.

        try {
            // fetch API를 사용하여 서버의 삭제 API('/api/articles/{id}')에 DELETE 요청을 보냅니다.
            const res = await fetch(`/api/articles/${id}`, {
              method: 'DELETE',
              headers: token ? { [header]: token } : undefined, // CSRF 토큰 헤더 추가
              credentials: 'same-origin'
            });

            if (!res.ok) {
                return alert('삭제 실패: ' + res.status);
            }

            alert('삭제가 완료되었습니다.');
            // 게시글 삭제 성공 시, 게시글 목록 페이지로 이동합니다.
            location.replace('/articles');

        } catch (error) {
            console.error('Error deleting article:', error);
            alert('삭제 중 오류가 발생했습니다.');
        }
    });
}

// --- 게시글 수정 기능 ---
const modifyButton = document.getElementById('modify-btn'); // '수정' 버튼 요소를 가져옵니다.

if (modifyButton) { // '수정' 버튼이 현재 페이지에 존재하는 경우
    modifyButton.addEventListener('click', async () => {
        const id = document.getElementById('article-id')?.value; // 숨겨진 input에서 게시글 ID를 가져옵니다.
        if (!id) return alert('id가 없습니다.');

        // 폼에 입력된 새로운 제목과 내용을 가져와 body 객체를 만듭니다.
        const body = {
            title: document.getElementById('title').value,
            content: document.getElementById('content').value
        };

        const { header, token } = csrf(); // CSRF 토큰 정보를 가져옵니다.

        try {
            // fetch API를 사용하여 서버의 수정 API('/api/articles/{id}')에 PUT 요청을 보냅니다.
            const res = await fetch(`/api/articles/${id}`, {
              method: 'PUT', // HTTP 메소드
              headers: {
                "Content-Type": "application/json",
                ...(token ? { [header]: token } : {}) // CSRF 토큰 헤더 추가
              },
              body: JSON.stringify(body), // 수정할 데이터를 JSON 문자열로 변환하여 요청 본문에 담습니다.
              credentials: 'same-origin'
            });

            if (!res.ok) {
                return alert('수정 실패: ' + res.status);
            }

            alert('수정이 완료되었습니다.');
            // 게시글 수정 성공 시, 수정된 게시글의 상세 페이지로 이동합니다.
            location.replace(`/articles/${id}`);

        } catch (error) {
            console.error('Error updating article:', error);
            alert('수정 중 오류가 발생했습니다.');
        }
    });
}

