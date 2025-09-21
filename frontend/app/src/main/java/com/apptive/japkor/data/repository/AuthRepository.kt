package com.apptive.japkor.data.repository

import com.apptive.japkor.auth.AuthManager
import com.apptive.japkor.data.model.UserData
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

object AuthRepository {
    suspend fun firebaseSignIn(idToken: String): UserData = suspendCancellableCoroutine { cont ->
        try {
            AuthManager.firebaseAuthWithGoogle(idToken) { success, err ->
                if (success) {
                    val firebaseUser = FirebaseAuth.getInstance().currentUser
                    if (firebaseUser != null) {
                        val userData = UserData(
                            uuid = firebaseUser.uid,
                            email = firebaseUser.email ?: "",
                            username = firebaseUser.displayName ?: ""
                        )
                        cont.resume(userData)
                    } else {
                        cont.resumeWithException(Exception("Firebase 사용자 정보가 비어있습니다."))
                    }
                } else {
                    cont.resumeWithException(Exception(err ?: "Firebase 인증 실패"))
                }
            }
        } catch (e: Exception) {
            cont.resumeWithException(e)
        }
    }

    // 서버 api
//    suspend fun signUp(userData: UserData): Response<PostResponse> =
//        withContext(kotlinx.coroutines.Dispatchers.IO) {
//            try {
//                apiService.signup(userData).execute()
//            } catch (e: Exception) {
//                throw e
//            }
//        }
}
