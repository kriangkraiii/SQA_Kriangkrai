from flask import Flask, request
from flask_restful import Resource, Api
from flasgger import Swagger

app = Flask(__name__)
api = Api(app)
swagger = Swagger(app)

# ข้อมูล playlists สำหรับ MoviePortal
playlists_data = [
    {
        "playlist_id": 1,
        "playlist_name": "datenight",
        "movie_list": ["The Notebook", "50 First Dates", "A Walk to Remember"]
    },
    {
        "playlist_id": 2,
        "playlist_name": "action",
        "movie_list": ["Die Hard", "Mad Max: Fury Road", "John Wick"]
    },
    {
        "playlist_id": 3,
        "playlist_name": "comedy",
        "movie_list": ["Superbad", "Step Brothers", "The Hangover"]
    }
]

class MoviePortal(Resource):
    def get(self):
        """
        Get all playlists from MoviePortal
        ---
        responses:
          200:
            description: A list of all movie playlists
            schema:
              type: array
              items:
                type: object
                properties:
                  playlist_id:
                    type: integer
                    description: The playlist ID
                  playlist_name:
                    type: string
                    description: The name of the playlist
                  movie_list:
                    type: array
                    items:
                      type: string
                    description: List of movies in the playlist
        """
        return playlists_data, 200

    def post(self):
        """
        Create a new playlist in MoviePortal
        ---
        parameters:
          - in: body
            name: Playlist
            required: true
            schema:
              id: Playlist
              required:
                - playlist_name
                - movie_list
              properties:
                playlist_name:
                  type: string
                  description: The name of the playlist
                movie_list:
                  type: array
                  items:
                    type: string
                  description: List of movies in the playlist
        responses:
          201:
            description: A new playlist created successfully
          400:
            description: Bad request - missing required fields
        """
        data = request.get_json()
        
        # ตรวจสอบว่ามีข้อมูลที่จำเป็น
        if not data or 'playlist_name' not in data or 'movie_list' not in data:
            return {'message': 'Missing required fields: playlist_name and movie_list'}, 400
        
        # สร้าง ID ใหม่
        new_id = playlists_data[-1]['playlist_id'] + 1 if playlists_data else 1
        
        new_playlist = {
            'playlist_id': new_id,
            'playlist_name': data['playlist_name'],
            'movie_list': data['movie_list']
        }
        
        playlists_data.append(new_playlist)
        return new_playlist, 201


class PlaylistByName(Resource):
    def get(self, playlist_name):
        """
        Get a playlist by name
        ---
        parameters:
          - name: playlist_name
            in: path
            type: string
            required: true
            description: The name of the playlist to search
        responses:
          200:
            description: Found a playlist
            schema:
              type: object
              properties:
                playlist_id:
                  type: integer
                playlist_name:
                  type: string
                movie_list:
                  type: array
                  items:
                    type: string
          404:
            description: Playlist not found
        """
        for playlist in playlists_data:
            if playlist['playlist_name'].lower() == playlist_name.lower():
                return playlist, 200
        
        return {'message': 'Playlist not found'}, 404


class PlaylistById(Resource):
    def get(self, playlist_id):
        """
        Get a playlist by ID
        ---
        parameters:
          - name: playlist_id
            in: path
            type: integer
            required: true
            description: The ID of the playlist to search
        responses:
          200:
            description: Found a playlist
          404:
            description: Playlist not found
        """
        for playlist in playlists_data:
            if playlist['playlist_id'] == playlist_id:
                return playlist, 200
        
        return {'message': 'Playlist not found'}, 404

    def put(self, playlist_id):
        """
        Update a playlist by ID
        ---
        parameters:
          - name: playlist_id
            in: path
            type: integer
            required: true
            description: The ID of the playlist to update
          - in: body
            name: Playlist
            required: true
            schema:
              id: UpdatePlaylist
              properties:
                playlist_name:
                  type: string
                  description: The name of the playlist
                movie_list:
                  type: array
                  items:
                    type: string
                  description: List of movies in the playlist
        responses:
          200:
            description: Playlist updated successfully
          404:
            description: Playlist not found
        """
        data = request.get_json()
        
        for playlist in playlists_data:
            if playlist['playlist_id'] == playlist_id:
                if 'playlist_name' in data:
                    playlist['playlist_name'] = data['playlist_name']
                if 'movie_list' in data:
                    playlist['movie_list'] = data['movie_list']
                return playlist, 200
        
        return {'message': 'Playlist not found'}, 404

    def delete(self, playlist_id):
        """
        Delete a playlist by ID
        ---
        parameters:
          - name: playlist_id
            in: path
            type: integer
            required: true
            description: The ID of the playlist to delete
        responses:
          200:
            description: Playlist deleted successfully
          404:
            description: Playlist not found
        """
        for i, playlist in enumerate(playlists_data):
            if playlist['playlist_id'] == playlist_id:
                deleted_playlist = playlists_data.pop(i)
                return {'message': 'Playlist deleted successfully', 'deleted_playlist': deleted_playlist}, 200
        
        return {'message': 'Playlist not found'}, 404


# Routes
api.add_resource(MoviePortal, '/playlists')
api.add_resource(PlaylistByName, '/playlists/name/<string:playlist_name>')
api.add_resource(PlaylistById, '/playlists/<int:playlist_id>')

# Run the app
if __name__ == '__main__':
    app.run(debug=True)